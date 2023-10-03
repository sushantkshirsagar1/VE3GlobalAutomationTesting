package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Class1;
import utility.ReadDataFromConfig;

public class BaseTest {
	public static WebDriver driver;
	
	public Class1 cl;
	
	@BeforeSuite
	public void initBrowser() throws IOException {
//		System.setProperty("webdriver.chrome.driver", "E:\\desktop\\Katraj\\15 Jan\\Selenium\\Chromedriver 101\\chromedriver.exe");

		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
//		options.addArguments("--incognito");
		
		options.addArguments("--start-maximized");
		
		//options.addArguments("--headless");
//		Headless is a mode in which we execute the script but it will not display any activity to the user 
		
		driver = new ChromeDriver(options);// chrome browser will get open

//		driver.manage().window().maximize();// to maximize the window

		String url = ReadDataFromConfig.getPropData("testurl");
		
		driver.get(url);
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
	
	@BeforeClass
	public void objectCreation() throws IOException
	{
		 cl = new Class1(driver);
	}
	
}
