package com.weirdo.rough;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;

public class TagingThroughtClass {
	
	public ExtentReports extend;
	public ExtentSparkReporter htmlFile;
	public ExtentTest test;
	WebDriver driver;
	@BeforeTest
	public void createReportInstance()
	{
		htmlFile=new ExtentSparkReporter("reports.html");
		extend =new ExtentReports();
		extend.attachReporter(htmlFile);
		
	}
	
	@Test(groups = { "t:AssertionError", "a:Naveen", "d:Chrome" })
	public void logDetailsDeiplay()
	{
		
		Assert.assertTrue(false);
		test.pass("TestCase passed");
		
		
	}
	@Test(timeOut=1000,groups = {  "t:AssertionError", "a:Rajan", "d:IE" })
	public void launchGoogle() throws Exception
	{
		try {
			test=extend.createTest("T2_launchGoogle");
			
			
			System.out.println("T2_launchGoogle");
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("https://www.google.com/");
			Thread.sleep(5000);
			test.pass("T2_launchGoogle");
			driver.findElement(By.name("q")).sendKeys("Hellow",Keys.ENTER);
			String expectedValue="Hellow - Google Search";
			String actualResult=driver.getTitle();
			Assert.assertEquals(actualResult,expectedValue,"Title Mismatched");
			Thread.sleep(5000);
			
			driver.quit();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.FAIL,"SomeThing went wrong").info(e);
		}
		
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
