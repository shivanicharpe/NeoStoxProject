package NeoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import NeoStoxUtility.Utility;



public class NeoStoxSignLogin
{
	
	
	@FindBy(name="ctl00$MainContent$signinsignup$txt_mobilenumber") private WebElement phoneNoFiled;
	
	@FindBy(id="lnk_signup1")  private WebElement SignUpButton;
	
	
	
	public NeoStoxSignLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
   
	public void EnterPhoneNo(WebDriver driver ,String PhoneNum)
	{
	    Utility.wait(driver, 2000);
	    
		phoneNoFiled.sendKeys(PhoneNum);
	
		Reporter.log("Entering Mobile Number ", true);
	}
	
	public void clickOnSignUpButton(WebDriver driver)
	{
		Utility.wait(driver, 1000);
		
		SignUpButton.click();
	
		Reporter.log("Clicking on sign in Button ", true);
	}
}
