package extentListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGen {

static ExtentReports extent;
	
	public static ExtentReports extentReportGenerator()
	{
		
		String path = System.getProperty("user.dir")+"//reports//ve3globalreport.html//";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setTheme(Theme.DARK);
		
		reporter.config().setReportName("VE3 Report");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Project name", "VE3 Global");
		
		extent.setSystemInfo("Environment", "SIT");
		
		extent.setSystemInfo("Executed by", "Sushant");
		
		return extent;
	}
}
