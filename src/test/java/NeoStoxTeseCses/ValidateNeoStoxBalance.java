package NeoStoxTeseCses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import NeoStoxBase.Base;
import NeoStoxPOM.NeoStoxHome;
import NeoStoxPOM.NeoStoxPassword;
import NeoStoxPOM.NeoStoxSignLogin;
import NeoStoxUtility.Utility;



public class ValidateNeoStoxBalance extends Base
{
	NeoStoxSignLogin login;
	
	NeoStoxPassword password;
	
	NeoStoxHome home;
	
	@BeforeClass
	public void launchNeoStox()
	{
		launchBrowser();
		
		login = new NeoStoxSignLogin(driver);
		
		password = new NeoStoxPassword(driver);
		
		home = new NeoStoxHome(driver);
	
		
	}
	
	@BeforeMethod
	public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	{
		login.EnterPhoneNo(driver, Utility.readDataFromExcel(0, 0));
	
		login.clickOnSignUpButton(driver);
		
		Thread.sleep(5000);
		
		password.enterPassword(driver, Utility.readDataFromExcel(0, 1));
		
		password.clicksubmitButton(driver);
		
		Thread.sleep(2000);
		
		home.popUpHandle(driver);
		
	}
  @Test
  public void validateAccountBalance()
  {

	  Assert.assertNotNull(home.getFunds(driver));
	  
	  Reporter.log("AC Balance is "+home.getFunds(driver), true);
	  
  }
  
  @AfterMethod
  public void logout() throws InterruptedException
  {
	 
	 
	 home.logoutFromNeoStox(driver);
	  
  }
  
  @AfterClass
  public void closingBrowser() throws InterruptedException
  {
	  closeBrowser(driver);
  }
}
