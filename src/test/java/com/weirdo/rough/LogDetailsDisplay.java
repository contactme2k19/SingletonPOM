package com.weirdo.rough;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hpsf.Array;
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

public class LogDetailsDisplay {
	
	
	
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
		
		test=extend.createTest("TesrName1");
		test.log(Status.INFO, "Hellow!!")
		.log(Status.INFO, "<i><b>Hello</b></i>");
		
		String xmlData="<note>\r\n"
				+ "<to>Tove</to>\r\n"
				+ "<from>Jani</from>\r\n"
				+ "<heading>Reminder</heading>\r\n"
				+ "<body>Don't forget me this weekend!</body>\r\n"
				+ "</note>";
		test=extend.createTest("XML");
		test.log(Status.INFO, MarkupHelper.createCodeBlock(xmlData,CodeLanguage.XML));
		
		String jsonData="{\r\n"
				+ "    \"fruit\": \"Apple\",\r\n"
				+ "    \"size\": \"Large\",\r\n"
				+ "    \"color\": \"Red\"\r\n"
				+ "}";
		test=extend.createTest("JSON")
				.log(Status.INFO,MarkupHelper.createCodeBlock(jsonData,CodeLanguage.JSON));
		
		
		
		List<String> listData= new ArrayList<>();
	listData.add("Abcd");
	listData.add("Efgh");
	listData.add("Ijklm");
	
	Map<Integer, String> mapData= new HashMap<>();
	mapData.put(1, "Naveen");
	mapData.put(2, "Kumar");
	mapData.put(3, "Hellow");
	
	Set<Integer> setData= mapData.keySet();
	test=extend.createTest("List, Map, Set datas")
			.log(Status.INFO,MarkupHelper.createOrderedList(listData))
			.log(Status.INFO, MarkupHelper.createUnorderedList(mapData))
			.log(Status.INFO, MarkupHelper.createUnorderedList(setData));
	test=extend.createTest("Higligth the test steps")
			.log(Status.INFO,MarkupHelper.createLabel("Higlight the lisne", ExtentColor.BROWN));
	//Print the exception 
	try {
		int i=5/0;
	}catch (Exception e)
	{
		test=extend.createTest("Show Exception in report")
				.info(e);
	}
	Throwable t = new RuntimeException("This is a exception while running a code");

			test.info(t);
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



