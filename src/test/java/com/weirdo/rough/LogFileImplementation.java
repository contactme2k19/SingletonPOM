package com.weirdo.rough;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogFileImplementation {
	//public static Logger log=Logger.getLogger(LogFileImplementation.class.getName());
	public static Logger log = Logger.getLogger("devpinoyLogger");

	public static void main(String[] args) {	
		
		Date d= new Date();
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));

	
		PropertyConfigurator.configure("./src/test/resources/com/weirdo/properties/log4j.properties");
		// TODO Auto-generated method stub
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().driverVersion("120.0.6099.109").setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com");
log.debug("Broswer loaded!!!!!");
driver.quit();
log.debug("Broswer Closed!!!!!");

	}

}
