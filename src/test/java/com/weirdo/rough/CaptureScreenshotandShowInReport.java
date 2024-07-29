package com.weirdo.rough;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.weirdo.utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshotandShowInReport {
	public ExtentReports extend;
	public ExtentSparkReporter htmlFile;
	public ExtentTest test;
	public static WebDriver driver;
	//public  WebDriverManager chdriver;
	@BeforeTest
	public void createReportInstance()
	{
		htmlFile=new ExtentSparkReporter("reports.html");
		extend =new ExtentReports();
		extend.attachReporter(htmlFile);
		
	}
	
	@Test
	public void logDetailsDisplay()
	{
		
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	String screenshotpath=Utilities.capturescreenshot1("screencapture.jpg");
		String baseb4=Utilities.capturescreenshotBase64();
		test=extend.createTest("Captureing screenshot");
		//test.log(Status.INFO, "Base64_Screen shot").addScreenCaptureFromBase64String(baseb4);
		//test.log(Status.INFO, "ScreenShot from path").addScreenCaptureFromPath(screenshotpath, "Attached from path");
		test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(baseb4).build());
		
	}
	
@AfterTest
public void teardown()
{
	extend.flush();
	try {
		Desktop.getDesktop().browse(new File("reports.html").toURI());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

