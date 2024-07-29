package com.weirdo.pages;



import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.weirdo.base.Page;
import com.weirdo.listeners.ExtentListeners1;

public class SearchPage extends Page{
	
	public void  searchAccounts(String SearchValue) {
		//Filter Accounts by

	//driver.findElement(By.xpath("//*[text()='Filter Accounts by']"));
		SoftAssert sf= new SoftAssert();
		isElementPresent("searchFilterLabel_XPATH", 10);
		type("searchBox_XPATH", SearchValue, 0);
		sf.assertTrue(isElementPresent("noValue_XPATH", 5),"Value is not retrived");
		ExtentListeners1.test.log(Status.PASS, "Serach value is not retrived ");
		
		sf.assertAll();
		
		

		
		
		
		
		
	}

}
