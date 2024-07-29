package com.weirdo.rough;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.weirdo.testcases.BaseTest;

public class ExternalReportTest extends BaseTest {

	public ExtentSparkReporter htmlReporter;// To create a html file and add config or customize the report
	public ExtentReports extent;// Attact reporter and create testcases
	public ExtentTest test;// To add the log info to test methods accros the project

	/*
	 * @BeforeTest public void setReport() {
	 * 
	 * htmlReporter= new ExtentSparkReporter(".report/extentReport.html");
	 * htmlReporter.config().setEncoding("UTF-8"); htmlReporter.config().
	 * setDocumentTitle("Page Object Model WithoutPage Foctory");
	 * htmlReporter.config().setReportName("Test Execution Report");
	 * htmlReporter.config().setTheme(Theme.STANDARD);
	 * 
	 * extent=new ExtentReports(); extent.attachReporter(htmlReporter); Add user
	 * level report here extent.setSystemInfo("Automation Tester:", "Naveen Kumar");
	 }*/ 

	@Test
	public void doLogin() {
		// test= extent.createTest("Login");
		test.log(Status.INFO, "EnteringUserName");

	}

	@Test
	public void doFail() {
		//test = extent.createTest("Delibrate Fail");
		test.log(Status.INFO, "Intentional failing testcase");
		Assert.fail("Failing testcase");

	}

	@Test
	public void doSkip() {
		//test = extent.createTest("Delibrate Skip");
		test.log(Status.INFO, "Intentional Skipping testcase");
		throw new SkipException("Force skip...");

	}

	/*
	 * @AfterMethod public void UpdateResults(ITestResult result) {
	 * 
	 * if (result.getStatus() == ITestResult.FAILURE) {
	 * 
	 * String methodName = result.getMethod().getMethodName();
	 * 
	 * Markup m = MarkupHelper.createLabel("Failure in this method--->" +
	 * methodName, ExtentColor.RED); test.fail(m); } else if (result.getStatus() ==
	 * ITestResult.SUCCESS) { String methodName =
	 * result.getMethod().getMethodName(); Markup m =
	 * MarkupHelper.createLabel("Testcase Executed" + methodName + " successfuly!!",
	 * ExtentColor.GREEN); test.pass(m); } else if (result.getStatus() ==
	 * ITestResult.SKIP) { String methodName = result.getMethod().getMethodName();
	 * Markup m = MarkupHelper.createLabel("Skipping this method-->" + methodName +
	 * " for below reason...", ExtentColor.AMBER); test.skip(m); } }
	 * 
	 * @AfterTest public void endReport() { extent.flush(); }
	 */
}
