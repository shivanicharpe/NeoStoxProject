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



public class ValidateNeoStoxUserName extends Base
{
	
	NeoStoxSignLogin login;
	
	NeoStoxPassword Password;
	
	NeoStoxHome home;
	
	
	@BeforeClass
	public void launchNeoStox()
	{
		launchBrowser();
		
		login = new NeoStoxSignLogin(driver);
		
		Password = new	NeoStoxPassword(driver);
	
		 home = new  NeoStoxHome(driver);
	}
	
	
	@BeforeMethod
	public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	{
		login.EnterPhoneNo(driver, Utility.readDataFromExcel(0, 0));
		
		login.clickOnSignUpButton(driver);
		
		Thread.sleep(1000);
		
		Password.enterPassword(driver, Utility.readDataFromExcel(0, 1));
		
		Password.clicksubmitButton(driver);
		
		Thread.sleep(1500);
		
		home.popUpHandle(driver);
		
		
	}
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
  {
	  Assert.assertEquals(home.getUserName(),Utility.readDataFromExcel(0, 2) ,"TC is failed, actual and expected User Names are not Matching ");
	  
	  Utility.takeScreenshot(driver,home.getUserName());
	  
  }
  
  @AfterMethod
  public void logout() throws InterruptedException
  {
	  home.logoutFromNeoStox(driver);
  }
  
  @AfterClass
  public void closeApplication() throws InterruptedException
  {
	  closeBrowser(driver);
  }
}
