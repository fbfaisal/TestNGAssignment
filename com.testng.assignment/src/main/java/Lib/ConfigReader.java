package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties pro;
	public ConfigReader() {
		
		try {
			File src=new File("./Configuration/config.property");
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} 
		
		catch (Exception e) {
			
			System.out.println("exception is=="+e.getMessage());
		}
		
	}

	
	public String getchromepath() {
		
	return	pro.getProperty("ChromeDriver");
		
	}
	
	public String getIEpath() {
		
	return	pro.getProperty("IEDriver");
	}

	public String getURL() {
		
	return	pro.getProperty("URL");
	
	
	}

	
}

