package com.weirdo.rough;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AttributesOnExtReport {
	
	
	
	
	public ExtentReports extend;
	public ExtentSparkReporter htmlFile;
	public ExtentTest test;
	
	@BeforeTest
	public void createReportInstance()
	{
		htmlFile=new ExtentSparkReporter("reports.html");
		extend =new ExtentReports();
		extend.attachReporter(htmlFile);
		
	}
	
	@Test
	public void logDetailsDeiplay()
	{
		
		test=extend.createTest("TesrName1").assignAuthor("Naveen")
				.assignCategory("Error")
				.assignDevice("Chrome");
		test.pass("TestCase passed");
		test=extend.createTest("TesrName2").assignAuthor("Naveen")
				.assignCategory("Error")
				.assignDevice("Chrome");
		test.fail("Testcase Failes as expected");
		test=extend.createTest("TesrName3").assignAuthor("Bala")
				.assignCategory("Exception")
				.assignDevice("Chrome");
		
		test=extend.createTest("TesrName4").assignAuthor("Naveen")
				.assignCategory("Exception")
				.assignDevice("Chrome");
		test.fail("TesrName4");
		test=extend.createTest("TesrName5").assignAuthor("Gugan")
				.assignCategory("Exception")
				.assignDevice("Chrome");
		test.fail("TesrName5");
		test=extend.createTest("TesrName6").assignAuthor("Pavandhan")
				.assignCategory("NullError")
				.assignDevice("Chrome");
		test.fail("TesrName6");
		test=extend.createTest("TesrName7").assignAuthor("Naveen")
				.assignCategory("NullError")
				.assignDevice("Chrome");
		test.fail("TesrName7");
		test=extend.createTest("TesrName8").assignAuthor("Naveen")
				.assignCategory(new String[] {"Warning","Exception","NullError"})
				.assignDevice("Chrome");
		test.fail("TesrName7");
		
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


