package NeoStoxUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Utility 
{
	//commanly used Methods
    //Excel reading ,Screenshot ,Wait ,Scrolling	
	
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		
	File myFile = new File("D:\\EXCEL\\book\\Book3.xlsx");
	
	String Value = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
	
	Reporter.log("Entering Data From Excel ",true);

	return Value;
	
	}
	
	public static void takeScreenshot(WebDriver driver, String fileName)
	{
		File Srouce = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		
		
		
		
		
		
		
		
		
		
		File destination = new  File("D:\\TakeScreenshotUsingSelenium"+fileName+".jpg");
		
		Reporter.log("Taking Screenshot ",true);
		
	}
	
	public static void scrollIntoView(WebDriver driver , WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
	
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	
		Reporter.log("Scrolling to "+element.getText(),true);
	}
	
	public static void wait(WebDriver driver , int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		
		Reporter.log("Waiting for "+waitTime+" miils", true);
	}

}
