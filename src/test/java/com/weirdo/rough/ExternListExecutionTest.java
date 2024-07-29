package com.weirdo.rough;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.weirdo.listeners.ExtentListeners1;
import com.weirdo.testcases.BaseTest;

public class ExternListExecutionTest extends BaseTest {
	
	@Test
	public void doLogin_Pass()
	{
		ExtentListeners1.test.log(Status.INFO,"EnteringUserName");
		Assert.assertTrue(true);
		ExtentListeners1.test.log(Status.INFO,"Do Login success");
	
	}
@Test
public void doLogin_Fail() {
	ExtentListeners1.test.log(Status.FAIL,"Failing Test case");
	Assert.fail("Failing testcase");
	
}
@Test
public void doiLogin_Skip() {
//	ExtentListeners.test.log(Status.INFO,"Intentional Skipping testcase");
	throw new SkipException("Force skip...");
}
}
