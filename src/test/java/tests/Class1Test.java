package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import extentListeners.Listeners;
import utility.XLUtils;

public class Class1Test extends Listeners {

	@Test(priority=1)
	public void testID_01() {
		// Navigating from News to Homepage by clicking the VE3 icon
		
		cl.clickOnHomepageButton();
		Reporter.log("Clicked on Homepage button");
	}
	
	@Test(priority=2)
	public void testID_02() {
		//Homepage title validation 
		
		String actualtitle = cl.getPageTitle1();
		
		String expectedtitle = "VE3 - Digital Solutions for the Future";
		if(expectedtitle.equals(actualtitle)) {
			
			System.out.println("Page Title has been Verified");
			
		}
		else
		{
			System.out.println("Page Title Validation Failed");
		}
	}
	
	@Test(priority=3)
	public void clickOnContact() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-times fa-w-11']")).click();
		cl.clickOnContactTab();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement web = driver.findElement(By.xpath("//*[@name='name-1']"));
		jse.executeScript("arguments[0].scrollIntoView();", web );
	}
	
	@Test(priority=4)
	public void testingBlankForm() {
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//verify that Website does not allow the user to submit form when no data filled in FirstName and Email Field
		WebElement sendbutton = driver.findElement(By.xpath("//*[text()='Send']"));
		sendbutton.click();
		String actual_FirstNameError = driver.findElement(By.xpath("//span[@id='forminator-field-name-1_6516f6d813a64-error']")).getText();
		String expected_FirstNameError = "This field is required. Please input your name.";
		
		if(actual_FirstNameError.equals(expected_FirstNameError)) {
			
			Assert.assertEquals(actual_FirstNameError, expected_FirstNameError);
			System.out.println("FirstName Field Error verified successfully");
			
		}
		else {
			System.out.println("FirstName Error Verification Failed");
		}
		String actual_MailError = driver.findElement(By.xpath("//span[@id='forminator-field-email-1_6516f6d813a64-error']")).getText();
		String expected_MailNameError = "This field is required. Please input a valid email.";
		
		if(actual_MailError.equals(expected_MailNameError)) {
			
			Assert.assertEquals(actual_MailError, expected_MailNameError);
			System.out.println("Email Field Error verified successfully");
			
		}
		else {
			System.out.println("Email Error Verification Failed");
		}
		}
	
	@Test(priority=5, dataProvider="TestData")
	public void verifyingMandatoryFields(String fname, String mail) throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement FirstName = driver.findElement(By.xpath("//*[@name='name-1']"));
		WebElement Email = driver.findElement(By.xpath("//*[@name='email-1']"));
		FirstName.clear();
		Thread.sleep(3000);
		FirstName.sendKeys(fname);
		Thread.sleep(3000);
		Email.clear();
		Email.sendKeys(mail);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Send']")).click();//submit/send button
		Thread.sleep(3000);
		driver.get("https://www.ve3.global/contact/");
		WebElement web1 = driver.findElement(By.xpath("//*[@name='name-1']"));
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].scrollIntoView();", web1);
	}
	
	
	
	@DataProvider(name="TestData")
	public String [][] getData() throws IOException{
		{	String loginData[][]= {
					{"Sushant", "sushant@gmail.com" },
					{"Sush123", "sushant123@gmail.com"},
					{"Susha123@#", "sushant123#@gmail.com"}
			};
		
//		//getting data from excelfile
//		String path = System.getProperty("user.dir")+"//testdata\\TestData.xlsx";
//		
//		XLUtils util = new XLUtils(path);
//      	int totalrows=util.getRowCount("TestData");
//      	int totalcols = util.getCellCount("TestData", 1);
//      	
//      	String loginData[][]=new String[totalrows][totalcols];
//      	
//      	for(int i =1; i<=totalrows; i++) {
//      		
//      		for(int j=0; j<totalcols; j++) {
//      			loginData[i-1][j]=util.getCellData("TestData", i, j);
//      		}
//      		
//      	}
		return loginData;
			
		}
		

		}
	
	@Test(priority=6)
	public void validateOptionalFields() throws InterruptedException {
		//Verifying whether user is able to enter Subject and Message
		WebElement sub = driver.findElement(By.xpath("//*[@name='text-1']"));
		Actions act = new Actions(driver);
		Thread.sleep(4000);
		act.click(sub).sendKeys("Subject has been entered").sendKeys(Keys.TAB).sendKeys("Validating Message Field").build().perform();
	}
		
		
		
//	String path = System.getProperty("user.dir")+"//testdata//TestData.xlsx";
//	
//	File src = new File(path);
//
//	FileInputStream fis = new FileInputStream(src);
//
//	XSSFWorkbook wb = new XSSFWorkbook(fis);
//	XSSFSheet sh = wb.getSheet("TestData");
//	//XSSFSheet sh = wb.getSheetAt(0);
//	
//	int row = sh.getLastRowNum();
//	
//	System.out.println("Row count is :"+row);
//	
//	int column = sh.getRow(0).getLastCellNum();		
//		
//		System.out.println("Column count is :"+column);
//		String data [][] = new String [row+1][column];
//	
//	for(int i=0; i<=row;i++)
//	{
//		for(int j=0; j<column;j++ )
//		{
//			data [i][j]	=sh.getRow(i).getCell(j).getStringCellValue();
//		}
//	}
//	
//	return data;
//
//	
}


