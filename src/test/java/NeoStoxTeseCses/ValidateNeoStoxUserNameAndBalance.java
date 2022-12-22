package NeoStoxTeseCses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
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


public class ValidateNeoStoxUserNameAndBalance extends Base

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
		login.EnterPhoneNo(driver,Utility.readDataFromExcel(0, 0));
		
		login.clickOnSignUpButton(driver);
		
		Thread.sleep(1000);
		
		password.enterPassword(driver,Utility.readDataFromExcel(0, 1));
		Thread.sleep(4000);
		password.clicksubmitButton(driver);
		
		Thread.sleep(20000);
		
//		if(AlrtOkButton.isDisplayed)
//		{
			home.popUpHandle(driver);	
//		}
//		
//		
		
	}
  @Test
  public void ValidateUserName() throws EncryptedDocumentException, IOException
  {
	  Assert.assertEquals(home.getUserName(), Utility.readDataFromExcel(0, 2) , "TC is failed , Actual And Expected User Name Are not same");
	  
	  Utility.takeScreenshot(driver, home.getUserName());
	  
  }
  
  @Test
  public void checkBalance()
  {
	  Assert.assertNotNull(home.getFunds(driver));
	  
  }
  
  @AfterMethod
  public void LogoutFromNeoStox() throws InterruptedException
  {
	  home.logoutFromNeoStox(driver);
  }
  
  @AfterClass
  public void closingBrowser() throws InterruptedException
  {
	  Utility.wait(driver, 8000);
	  closeBrowser(driver);
  }
}
