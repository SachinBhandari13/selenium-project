import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class websiteLoginAutomation {

	public static void main(String[] args) throws InterruptedException {
		/*		8 locators in Selenium
		 * make sure following are unique to select them
			findElement(By.id("value"));                                    find by #id in html 
			findElement(By.name("value"));								    find by name in html. Name is attribute of input tag
			findElement(By.className("value"));                             find by .class name in html 
			findElement(By.linkText("value"));                              find by link text yaani <a href="....">yaha wala text is linktext</a>
			findElement(By.partialLinkText("value"));                       same as link text but exact match jaroori nahi. agar link text me forgot your password hai then here you can mention password and it will search in all <a> text and jisme pass hoga vo link select ho jaega
			findElement(By.tagName("value"));                               find all elements by a tag name like all <a> tags or all <p> tags....therefore must use findElements to capture all in a list
			findElement(By.xpath("value"));
			findElement(By.cssSelector("value"));		*/

		
		//inspect on webpage to get id,class,links ,etc
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Paapi Papita\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\chromedriver107.exe");

		//if your findElement is not unique then it will identify the first element it finds of that name
		WebDriver driver= new ChromeDriver();		
		driver.get("https://youtube.com");				//dummy login site
//		driver.findElement(By.className("oxd-icon bi-person oxd-input-group__label-icon")).sendKeys("Admin");			//sendkeys to enter something in input field
//		driver.findElement(By.className("oxd-input oxd-input--active")).sendKeys("admin123");
//		driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button")).click();				    //click to click on any locator which is clickable like button and links
//		driver.navigate().back();
//		driver.findElement(By.partialLinkText("Forgot your password?")).click();
//		driver.navigate().back();
//		driver.findElement(By.partialLinkText("password")).click();
		int i =1;
		while (i==1) {
			driver.navigate().refresh();
			TimeUnit.MINUTES.sleep(6);
		}
		
		/*if your findElement is not unique then it will identify the first element it finds of that name. If you want all the elements use
		findElements() which will return a list of all elements and then interate through it to perform any click or sendkeys*/

	}

}
