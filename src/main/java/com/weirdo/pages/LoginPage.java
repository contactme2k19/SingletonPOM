package com.weirdo.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.weirdo.base.Page;
import com.weirdo.listeners.ExtentListeners;



public class LoginPage extends Page{
	
	
	public void doLogin(String userName, String password)  {
		
           
      
			verifyAssert(isElementPresent("signInCheck_XPATH", 20), "Navigated to SignIn Page");
				type("userName_ID", userName,3);
				ExtentListeners.test.log(Status.INFO, "UserName entered as::"+userName);
				click("nextButton_ID", 2);
				type("password_ID", password,5);
				ExtentListeners.test.log(Status.INFO, "Password entered as::"+password);
				click("signINButton_XPATH", 1);
		
				verifyAssert(isElementPresent("cRMApp_XPATH",30),"CRM Link is clickable..");

	
		
	}


}
