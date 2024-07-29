package com.weirdo.pages;



import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.weirdo.base.Page;
import com.weirdo.listeners.ExtentListeners1;
import com.weirdo.listeners.ExtentListeners;


 
public class HomePage extends Page{
	public void launchBroswer() {
	
		driver.manage().window().maximize();
		driver.get(config.getProperty("testsiteurl"));
		ExtentListeners.test.log(Status.INFO, "Zoho App Launched");
		
	
	}
	public void launchgoogleBroswer() {
		//driver.manage().window().maximize();
		driver.get("https://www.google.com");
		ExtentListeners.test.log(Status.INFO, "GoogleApp Launched");
	
	}
	public void goToSignIn()  {
	    	verifyAssert(isElementPresent("signin_XPATH",20),"SignInButton is displayed");
			click("signin_XPATH", 0);
			System.out.println("Navigated to Sign In page....");
			
			//ExtentListeners.test.log(Status.INFO, "Navigated to Sign In page....");
			}
	public void goToSignInRoughVlaidation()   {
		Assert.assertTrue(isElementPresent("signinCheck_XPATH",1),"Signin Link is displayed");
		
		driver.findElement(By.xpath(OR.getProperty("signinCheck_XPATH"))).click();
		System.out.println("Navigated to Sign In page....");
		System.out.println("Throught catche block");
		
	}
	public void goToSignUp() {
		SoftAssert sf= new SoftAssert();
		sf.assertTrue(isElementPresent("signINButton_XPATH", 10), "SignIn buttion is  clickable");
		click("signINButton_XPATH", 1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
