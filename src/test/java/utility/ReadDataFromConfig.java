package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromConfig {

	public static String getPropData(String key) throws IOException
	{
		Properties prop = new Properties();
		
		String path = System.getProperty("user.dir")+"\\config.properties";
		
		FileInputStream fis = new FileInputStream(path);
		
		prop.load(fis);
		
		String value  = prop.getProperty(key);
		
		return value;
	}
	
}
