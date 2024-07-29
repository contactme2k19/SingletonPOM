package com.weirdo.pages.crm.accounts;

import com.aventstack.extentreports.Status;
import com.weirdo.base.Page;
import com.weirdo.listeners.ExtentListeners;
import com.weirdo.listeners.ExtentListeners1;

public class AccountsPage extends Page {
	
	public void gotoCreateAccount() {
		click("creatAccountButton_XPATH", 60);
		System.out.println("Navigated to create account page");
		ExtentListeners.test.log(Status.INFO, "Navigated to create account page");
	}

}
