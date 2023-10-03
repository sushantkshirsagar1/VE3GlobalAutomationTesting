package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {

	public static String captureScreenshotWithPath(WebDriver driver, String filename) throws IOException
	{
		
		TakesScreenshot scrshot = (TakesScreenshot)driver;
		
		File source = scrshot.getScreenshotAs(OutputType.FILE);
		
//		String path = "E:\\desktop\\Katraj\\15 Jan\\Selenium\\Capturedscreenshot\\"+filename+".png";

//		Alternate way to define the path
		
		String path = System.getProperty("user.dir")+"\\screenshots\\"+filename+".png";
		
		
		File destination = new File(path);
	
		FileHandler.copy(source, destination);
		
		return path;
}
}