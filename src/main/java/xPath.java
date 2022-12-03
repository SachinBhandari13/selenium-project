
		import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
		
public class xPath {


	public static void main(String[] args) throws InterruptedException, IOException {

		XSSFWorkbook wb = new XSSFWorkbook();   
//		added new comment 
		//added another comment
		XSSFSheet sheet = wb.createSheet("amazon price");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Paapi Papita\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\chromedriver107.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id =\"twotabsearchtextbox\"]")).sendKeys("white sneaker shoes for men under 1000");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

		Thread.sleep(2000);
		//product and price name list
				
		//mapped product with price
		Map<String, String> map = new HashMap<>();  //create map empty object
		
		List<WebElement> list_of_pages = driver.findElements(By.xpath("//a[@class = 's-pagination-item s-pagination-button']"));
		
	System.out.println(list_of_pages.toString());
		for(WebElement page: list_of_pages ) {
			
			List<WebElement> list_of_products = driver.findElements(By.xpath("//*[@class = \"a-size-medium a-color-base a-text-normal\"]"));
			List<WebElement> list_of_price = driver.findElements(By.xpath("//*[@class=\"a-price-whole\"]"));
		
		for (int i = 0; i < list_of_products.size(); i++) {  //iterate to list
			
			String name= list_of_products.get(i).getText(); 
			String price= list_of_price.get(i).getText();
			
			map.put(name, price);
			
		}
		
		int rowIndex=0;
	
		XSSFRow row1 = sheet.createRow(rowIndex++);
		row1.createCell(0).setCellValue("Product");
		row1.createCell(1).setCellValue("Price");
		
//		for ()
		for(String s : map.keySet()) {
			XSSFRow row = sheet.createRow(rowIndex++);
			
			XSSFCell cell1 = row.createCell(0);
			cell1.setCellValue(s);
			
			XSSFCell cell2 = row.createCell(1);
			cell2.setCellValue("Rs "+map.get(s));
			
		}

		Thread.sleep(2000);
		page.click();
		}
		
		FileOutputStream fo=new FileOutputStream(new File("C:\\Users\\Paapi Papita\\Desktop\\attemt2.xlsx"));
		wb.write(fo);
		fo.close();
		
		driver.close();
		
	}

	private static void xpath() {
		//below are all relative x-path
			
		/*in chrome open inspect and then press ctrl+f to write your xpath to point to a particular line in html code
		 *Syntax :    //*[@attribut='value']       here //* means search in all of the html doc
		  //*[@id='someId']  will highlight this id
		  //*[@value='value1']  will highlight this.

		   if you have 2 tags having same class...how will u identify
		   //tagName[condition]

		    //p[@id='id1' and @class='class1']    to uniquely identify something
		    //p[@id='id1' or @class='class1']    will identfy anything which is having either id=id1 or class=class1		    

		      //p[(@id='id1' or @class='class1') and @name='someName']     can combine more than 1 condition

		   //span[@id='someId']/..    iske ek parent upar ko identify krega. If we again use /.. then it will go one parent up and so on
		    //div[@id='divA']/p/span     parent se child me traverse krega.....its like address of directory...u can also do /p/span    yani div k andr p k andr span

		      double slash means anywhere inside it. Starting me // means anywhere in html aso u can do:
		      //div[@id='divA']//span  means iss div k andr kitne b nested me span ko doondhlo 


				//p[text()='someTExt in webpage']          to identify based on text inside p tag. Here we used text() function. More func explained in functionsOfXpath()

		      if we have many occurance then we can treat it like array(1 mtlb 1 na ki 0) like:
		      //p[@class='para'][1]     means suppose 3 p has class='para' then usme se 1st position wala
			
        (//label[@class='lable'])[2]  wrapped in () means this entire lable is present 3 times
		 
		 //a[.//span[@id='link']]   //a(suppose it dont have id/class to identify it) tag me directly search krne k liye .// and fir jo search krna uska x-path hi daldo 
		 
		 
		 */
		
		
		//absolute x-path (not recommended)
		///html/body/p/span/a                       poora path dena which is not recommended
		
		//advanced x-path concepts__________________________________________
		//1.Contains  : to replace equals(=)  sign with partial match anywhere 
		//p[contains(text() , 'a part')]			//<p>This is a part of sentence</p>  ise match kr dega by getting partial match.(1st para me kise match krna ans 2nd para me kya match krna) 
			//Remember we used text()='someTExt' to get exact match
		//div[contains(@id,'rtialId')]			//<div id="partialId"> </div>  ise match kr dega with partial match
		
		//2.startswith  :  (like contains only but will match from start)
		//p[starts-with(text() , 'This is')]
			
		//3.last() :   jaha pr bhi multiple results aaege and u want last element use this instead of using [7],[8]......so on
		//table[@class='A']//tr[last()]			//will get last wala tr....bs index( [n] )ki jagah last() use kro 
		//table[@class='A']//tr[last()-1]		//2nd last tr
		
		//4.count  :  to count no of occurences
		//table[count( .//tr )=6]		//jisme 6 tr honge vo wali table.		dot ka mtlb inside table tag..vrna vo poore doc me doondhne lg jaega
			//double slash means table k kitna b andr tr ko count kro
		
//		5.normalize-space : its like trim() which removes leading and trailing whitespaces from text() ya fir @id ya @class....
		//p[normalize-space(text()='Tommy')]		//<p> Tommy   </p>  ise match kr dega cuz whitespace remove ho gaye start and end se
		
//		6.translate()  :  to change lower to upper or vice-versa or anything
		//p[translate(text(), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ')]		//para1=text to translate  para2=kya change krna para2=kisme.
			//a ko A se krega b ko B se so on...if para1= acv and para2=AB hota to a and c ko A and B se change krta respectively and v ko nahi krta cuz uske respective koi value ni h
		
		//you can combine normalize-space() and translate() by: normalize-space(translate(text(), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'))
		
//		7. string-length()  : length of anythin like text() @id @class, etc
		//p[string-length(text()) > 5 ]
		
//		8.round() and floor() : to round off and floor integer value
		//p[round(text())='20']				//suppose we have <p>20.4</p>
		//p[floor(text())='20']				//suppose we have <p>20.8</p>
		
//		9. not : its like ! yaani jo b ho uska ulta
		//p[@class='A'  and not(@id='female')]			//all males aaenge cuz females pr not laga
		//p[not(@class='A')]			//all elements jinki class A nahi hai vo selected
		
//		10.subtring-after and substring-before : will substring before and after
		//p[substring-after(text(), ':')='10am']      //<p>Time is :10am</p>     ise match krega
		//p[substring-before(text(), ':')='Time is ']      //<p>Time is :10am</p>     ise match krega
		
//_______________________X-path axes(heirarchies)__________________________________
//		1. parent  : to get immediate parent
		//div[@id='b']/parent :: div		//iska 1st(just upar wala) div wala parent
		//div[@id='b']/parent :: * 			//iska 1st koi b parent          iski jagah we can also use /..  which also means iska 1st parent
		
//		2. ancestor : to get all parent(current wale element ko chdke)
		//div[@id='a']/ancestor::*		//sare parents aa jaaenge
		//div[@id='a']/ancestor::div[@class='1']		//top tk sare parents aa jaaenge jinki b id=1 hai
		
//		3. ancestor-or-self : to get all parent(including current element)
		//div[@id='a']/ancestor-or-self::*		//sare parents aa jaaenge including this div jiski id=a hai
		//div[@id='a']/ancestor-or-self::div[@class='1']		//top tk sare parents aa jaaenge including this div jiski id=a hai jinki bhi id=1 hai
		
//		4. child : to get all child elements
		//div[@id='a']/child::*				//sare child
		//div[@id='a']/child::div[@id=1]	//vo child jo div hai with id=1	
		
//		5. descendant : saare child and sub child sab aa jaaenge
		//div[@id='a']/descendant::*				//sare child and sub-child
		//div[@id='a']/descendant::div[@id=1]	//vo child or sub-child jo div hai with id=1
		
//		6. following : saare element iske baad k....html doc me jo b iske baad aara end tk vo sab
		//div[@id='a']/following::*			//will give upto last line all the elements (even nested  yaani iske baad koi <p> h jisme <a> h to ye nested yaani <a> me bhi jaaega)

//		7. following-sibling : same level element iske baad k
		//div[@id='a']/following-sibling::*			//will give upto last line all the elements (not nested yaani iske baad koi <p> h jisme <a> h to ye nested yaani <a> me nahi jaaega)
		
//		8. preciding and preceding-sibling	:  exact opposite of following and following-sibling
		
		
	}

	private static void functionsOfXpath() {
		/*
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		 * */
	}

}
