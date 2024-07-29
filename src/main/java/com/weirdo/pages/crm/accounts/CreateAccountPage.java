package com.weirdo.pages.crm.accounts;

import com.aventstack.extentreports.Status;
import com.weirdo.base.Page;
import com.weirdo.listeners.ExtentListeners;
import com.weirdo.listeners.ExtentListeners1;

public class CreateAccountPage extends Page{

	public void createAccount(String accountName) throws Throwable
	{
		type("accountNameText_ID", accountName, 30);
		System.out.println("Entered AccountName-->"+accountName);
		ExtentListeners.test.log(Status.INFO, "Entered AccountName-->"+accountName);
	//	selectDropdownoption("accountType_XPATH", "Competitor");
		Thread.sleep(5000);
	}
}
