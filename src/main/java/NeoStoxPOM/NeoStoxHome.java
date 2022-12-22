package NeoStoxPOM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import NeoStoxUtility.Utility;


public class NeoStoxHome 
{
	@FindBy(xpath="(//a[text()='OK'])[2]") private WebElement AlrtOkButton;
	
	@FindBy(xpath="(//a[text()='Close'])[5]") private WebElement AlrtCloseButton;
	
	@FindBy(id="lbl_username") private WebElement UserName;
	
	@FindBy(id="lbl_curbalancetop") private WebElement funds;
	
	@FindBy(xpath="//span[text()='Logout']") private WebElement Logoutbutton;
	
	
	public NeoStoxHome(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void popUpHandle(WebDriver driver) throws InterruptedException 
	{
		if(AlrtOkButton.isDisplayed())
		{
	     	Utility.wait(driver,1500);
		
		    AlrtOkButton.click();
		
		    Utility.scrollIntoView(driver, AlrtCloseButton);

		    Utility.wait(driver, 1000);
		
		    AlrtCloseButton.click();
		
		    Reporter.log("Handling Popup....", true);
		}
		else
		{
			Utility.wait(driver, 15000);
			
			Reporter.log("There is no Popup present....", true);
		}
	}
	
	
	public String getUserName()
	{
		String actualUserName = UserName.getText();
		
		Reporter.log("Getting User Name ", true);

		return actualUserName;
	}
	
	public String getFunds(WebDriver driver)
	{
		Utility.wait(driver, 1000);
		
		String availableFunds = funds.getText();
		
		Reporter.log("Getting actual fund", true);
		
		return availableFunds;
		
	}
	
	
	public void logoutFromNeoStox(WebDriver driver) throws InterruptedException
	{
		Utility.wait(driver, 1000);

		UserName.click();
		
		Utility.wait(driver, 1000);
	
		Logoutbutton.click();
		
		Reporter.log("Logging out fro neoStox", true);
	
	}
}
