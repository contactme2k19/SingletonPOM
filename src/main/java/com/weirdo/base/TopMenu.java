package com.weirdo.base;



import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TopMenu {
	
	/**
	 * This class contains the reusable methods which is common for all pages 
	 * here we do encapsulation 
	 * extend is not a right way here because this class is not a page  therefore we have created a constructor and then create a object in parent"page class inside the constructor"
	 */
	WebDriver driver;
	Properties OR;

	public TopMenu(WebDriver driver,Properties OR)
	{
		this.driver=driver;
		this.OR=OR;
		
	}
	
	
	
	
	
	public void goToAccounts() {
		

	Page.click("accounts_Menu_ID", 60);

	}


}
