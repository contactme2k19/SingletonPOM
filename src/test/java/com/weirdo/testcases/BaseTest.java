package com.weirdo.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.weirdo.base.Page;

public class BaseTest extends Page {
	@AfterSuite
	public void tearDown() {
		Page.quit();
	}

}
