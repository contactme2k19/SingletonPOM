package com.weirdo.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.google.common.io.Files;
import com.weirdo.base.Page;

public class Utilities extends Page {

	//public static String screenshotPath;
	public static String screenshotName;
	public static String capturescreenshotBase64()
	{
		TakesScreenshot takeScreenShot=(TakesScreenshot) driver;
		 String base64=takeScreenShot.getScreenshotAs(OutputType.BASE64);
		//File destination= new File("./screenshot/"+fileName);
		
		
		return base64;
	}
public static String capturescreenshot1(String fileName)
{
	TakesScreenshot takeScreenShot=(TakesScreenshot) driver;
	File sourceFile=takeScreenShot.getScreenshotAs(OutputType.FILE);
	File destination= new File("./screenshot/"+fileName);
	try {
		Files.copy(sourceFile, destination);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return destination.getAbsolutePath();
}
	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		Files.copy(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
		/*
		 * Files.copy(scrFile, new File(".\\reports\\" + screenshotName));
		 */
	}

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}
	
	
	
	public static  boolean isTestRunnable(String testName,ExcelReader excel) {
	String sheetName="test_suite";
		int rowCount=excel.getRowCount(sheetName);
		
		for(int rNum=2;rNum<=rowCount;rNum++) {
			String testNameFromExcel=excel.getCellData(sheetName, "TCID", rNum);
			System.out.println("TestcaseName read from excel sheet::"+testNameFromExcel);
			if(testNameFromExcel.equalsIgnoreCase(testName)) {
				String runmode=excel.getCellData(sheetName, "Runmode", rNum);
				System.out.println("Tescase RunMode set as::"+runmode);
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
				
			}
		}
		return false;
	}
	
	
	
}
