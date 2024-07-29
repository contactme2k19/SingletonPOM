package com.weirdo.pages;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.weirdo.base.Page;
import com.weirdo.listeners.ExtentListeners;
import com.weirdo.listeners.ExtentListeners1;

public class AppPage extends Page{
	
	
	public void goToCRM() {
		Assert.assertTrue(isElementPresent("cRMApp_XPATH",60),"CRM Link is clickable..");
		click("cRMApp_XPATH", 1);
		ExtentListeners.test.log(Status.INFO, "CRM Link is clickable..");
		
		
	}
	public void goToDesk() {
		
	}
	
	
	

}
