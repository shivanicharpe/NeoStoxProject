package NeoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import NeoStoxUtility.Utility;



public class NeoStoxPassword 
{
	
    @FindBy(id="txt_accesspin") private WebElement passwordFiled;
    
    @FindBy(id="lnk_submitaccesspin") private WebElement submitButton;
    
    public NeoStoxPassword(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void enterPassword(WebDriver driver ,String PSW) 
    {
    	Utility.wait(driver, 9000);
    	
    	passwordFiled.sendKeys(PSW);

    	Reporter.log("Entring Password ", true);
    }
    
    public void clicksubmitButton(WebDriver driver)
    {
    	Utility.wait(driver, 1500);
    	
    	submitButton.click();
    
    	Reporter.log("Clicking on submit button ", true);
    	
    }
}
