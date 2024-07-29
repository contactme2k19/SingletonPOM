package com.weirdo.listeners;

import java.io.IOException;
import java.util.Date;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.weirdo.base.Page;
import com.weirdo.utilities.Utilities;



public class ExtentListeners1 implements  ITestListener, ISuiteListener {

	static Date d = new Date();
	static String fileName = "Extent_"+d.toString().replace(":", "_").replace(" ", "_") +".html";

	//private static ExtentReports extent = ExtentManager.createInstance(".\\reports\\" + fileName);
	private static ExtentReports extent = ExtentManager.createInstance();

	public static ExtentTest test;
	
	
	
	
	
	@Override

	public void onTestStart(ITestResult result) {

		//test = extent.createTest(result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());
		
		if(!Utilities.isTestRunnable(result.getMethod().getMethodName(), Page.excel)) {
			test=extent.createTest(result.getName());
			throw new SkipException("Skipping the testcase based on the config");
		}

	}
	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);

	}
	@Override
	public void onTestFailure(ITestResult result) {
		

		///test.fail(result.getThrowable().getMessage());
		try {
			ExtentManager.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		test.log(Status.FAIL, "Failure due to below cause::"+result.getThrowable().getMessage());
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " FAILED"+"</b>";		
	    test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.fileName).build());
	    Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.log(Status.FAIL, m);
		
		

	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		test.log(Status.SKIP, methodName+"Skipping this testcase asper the Run mode is defined as N");
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.skip(m);

	}
	@Override

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override

	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}

	

}
