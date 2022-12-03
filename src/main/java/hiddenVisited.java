

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class hiddenVisited {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Paapi Papita\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();		
		driver.get("https://theautomationzone.blogspot.com/2020/06/visibile-and-hidden-webelements.html");
		
		//open webpage to see how is visibility working
		System.out.println("Display of image box: "+driver.findElement(By.id("hide")).isDisplayed());  //visibility before clicking button
		driver.findElement(By.id("hide")).click();											//click button		
		System.out.println("Display of image box: "+driver.findElement(By.id("hide")).isDisplayed());   //visibility after clicking button
		
		/* isEnabled is used to check if we can proceed with further automation cuz if false then it wont be clickable but no error is shown. 
		So check for clickability before moving further */
		System.out.println("Display of button : "+driver.findElement(By.id("button1")).isEnabled());	//check is button is clickable or not
		System.out.println("Display of button : "+driver.findElement(By.id("button2")).isEnabled());
		
		//for radio and checkboxes first check if they are already selected or not and then perform click() operation. Ex-
		if(!driver.findElement(By.id("button2")).isSelected())		//if this is false yaani not selected tabi checkbox1 pr click perform kro...same can be done for radio buttons too 
			driver.findElement(By.id("checkbox1")).click();
		
		Select select=new Select(driver.findElement(By.id("someDropDownMenu")));
		select.selectByIndex(0);						//1st element in dropdown in selected
		select.selectByVisibleText("anyOptionFromDropDown");              //selects on the exact dropdown item name
		select.selectByValue("somevalue");                           //hover on selectValue to see example of this function
		System.out.println(select.getFirstSelectedOption().getText());              //gets your selected text as a string
		
		//in case of multi-selectors we do following
		select.selectByIndex(0);
		select.selectByIndex(1);
		select.selectByIndex(3);		
		List<WebElement> listItems=select.getAllSelectedOptions();   //list of all selected items and call getText on WebElement object when iterating
		
		
		select.deselectAll();
		select.deselectByIndex(0);
		select.deselectByVisibleText("anyOptionFromDropDown");
		
		
		//get Text, getAttribute("textContent"), getAttribute("innerHTML")
		System.out.println(driver.findElement(By.id("p1")).getText());		//will get text in that p tag(if p1 tag me span tag nested hai then it will get text of that too. Its smart
		System.out.println(driver.findElement(By.id("p1")).getAttribute("textContent"));  //will give text as in html doc
		//(if it has <p>This     is     paragraph</p> then it will return exact same text with all spaces but in case of getText(), it would give text shown in browser,ie, without spaces)
		System.out.println(driver.findElement(By.id("p1")).getAttribute("innerHTML"));   //will print this is para <span> span tag in between</span> graph.(agar p k beech me span tag h to jabki upar k 2 doesnt print inner tags but theri content)
		
		System.out.println(driver.findElement(By.id("inputTag")).getAttribute("value"));  //to get value of tags like input box ya dropdown ya checkbox jinme text nahi h directly like <p>
		System.out.println(driver.findElement(By.id("anchortag")).getAttribute("href"));  //basically this will get you value of any tag in a attribute  
		
		driver.quit();
	}

}
