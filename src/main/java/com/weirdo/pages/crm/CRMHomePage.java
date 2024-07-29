package com.weirdo.pages.crm;

import com.aventstack.extentreports.Status;
import com.weirdo.base.Page;
import com.weirdo.listeners.ExtentListeners;
import com.weirdo.listeners.ExtentListeners1;

public class CRMHomePage extends Page{
	
	
	public void goToAccounts() {
		
	click("accountsMenu_XPATH", 60);
	System.out.println("Account buttion is clicked");
	ExtentListeners.test.log(Status.INFO, "Navigate to CRM Account Home Page....");
	}

}
