package NeoStoxBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import NeoStoxUtility.Utility;


public class Base
{
	protected WebDriver driver;
	
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32\\chromedriver.exe");

	    driver = new ChromeDriver();
		
		driver.get("https://neostox.com/sign-in");
		
		driver.manage().window().maximize();
		
		Reporter.log("Launching Browser ", true);

		Utility.wait(driver, 1000);
		
	}
	
	
	public void closeBrowser(WebDriver driver) throws InterruptedException
	{
		Reporter.log("Closing Browser ",true);
		
		Thread.sleep(1000);
		
		driver.close();
	}

}
