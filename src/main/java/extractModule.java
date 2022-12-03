import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class extractModule {

	public static void main(String[] args) {
		//DOM Structure is what you see when you inspect. Browser converts html text into DOM structure and then display
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Paapi Papita\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();		//create driver instance and opens a chrome browser
		driver.get("https://www.google.com");		//opens this url in chrome instance
		
		driver.navigate().to("https://www.fb.com");     //same as get but doesn't refresh page 
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.manage().window().maximize();    //can also full-screen using fullscreen()
		
		System.out.println(driver.getTitle());				//title of the webpage
		System.out.println(driver.getCurrentUrl());			//actual url of page...like fb.com visit krne pr url is facebook.com and not fb.com
		System.out.println(driver.getPageSource());			//html of entire page
		
		driver.navigate().to("https://www.youtube.com");
		driver.navigate().to("https://www.youtube.com");
		driver.navigate().to("https://www.youtube.com");
		
		driver.quit();			//closes all windows/tabs opened
//		driver.close();			//if more than 1 tabs/windows opened then closes the currently working one
		

	}

}
