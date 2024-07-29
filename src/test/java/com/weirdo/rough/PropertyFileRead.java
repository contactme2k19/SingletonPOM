package com.weirdo.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFileRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*Creating object or invoke the inbuilt class */
		WebDriver driver;
		Properties config=new Properties();
		Properties OR=new Properties();
		driver= new ChromeDriver();
		 driver.get("https://www.google.com");
/*Then create the object for read the property file with valid path on constructor part(right side )*/
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\weirdo\\properties\\Config.properties");
System.out.println(System.getProperty("user.dir"));
		/*Load the config file with object of file stream*/
		config.load(fis);
	/*Get the value from property file using getproperty*/
		System.out.println(config.getProperty("browser"));
		
		fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\weirdo\\properties\\OR.properties");
		OR.load(fis);
		System.out.println(OR.getProperty("loginlink_CSS"));	
		//public static
		if(config.getProperty("browser").equals("chrome"))
		{
			
			// driver.get(config.getProperty("testsiteurl"));
		
		}
		
		
	}

}
