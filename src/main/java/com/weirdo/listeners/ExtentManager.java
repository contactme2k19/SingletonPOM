package com.weirdo.listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.weirdo.base.Page;


public class ExtentManager {

	private static ExtentReports extent;
	public static String fileName;
	
	

	    public static ExtentReports createInstance() {
	    	Date d = new Date();
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(".\\reports\\" +"Extent_"+d.toString().replace(":", "_").replace(" ", "_") +".html");
	      
	        
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle("test");
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName("test");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Naveen Kumar");
	        extent.setSystemInfo("Organization", "GCIT");
	      
	        System.out.println(extent);
	        System.out.println(fileName);
	      
	  
	        return extent;
	        }

	    
		public static void captureScreenshot() throws IOException {
			
			Date d = new Date();
			 fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

			
			
			File screeshot = ((TakesScreenshot)  Page.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screeshot, new File(".//reports//"+fileName));
		}
		
		

		public static void captureElementScreenshot(WebElement element) throws IOException {
			
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
			File screeshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screeshot, new File(".//screenshot//"+"Element_"+fileName));
		}

	 


	}
