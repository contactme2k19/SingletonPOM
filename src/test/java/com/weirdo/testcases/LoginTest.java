package com.weirdo.testcases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.weirdo.base.Page;
import com.weirdo.listeners.ExtentListeners;
import com.weirdo.pages.AppPage;
import com.weirdo.pages.HomePage;
import com.weirdo.pages.LoginPage;
import com.weirdo.pages.SearchPage;
import com.weirdo.pages.crm.accounts.AccountsPage;
import com.weirdo.pages.crm.accounts.CreateAccountPage;
import com.weirdo.utilities.Utilities;

public class LoginTest extends BaseTest {
	public List<Throwable> errors = new ArrayList<>();
	
	
	@Test(priority = 1)
	public void launchBroswerandLoadZohoURL() {
		System.out.println("TC1-launchBroswerandLoadZohoURL");
		
			
			HomePage hp = new HomePage();
			hp.launchBroswer();
			hp.goToSignIn();
			
	}
	
	
	
	@Test(priority = 2,dataProviderClass = Utilities.class,dataProvider = "dp")
	public void signIntoZohoApp(Hashtable<String, String>data)  {
		System.out.println("TC2-signIntoZohoApp");

		/*HomePage hp = new HomePage();
		hp.launchBroswer();
		hp.goToSignIn();*/
				LoginPage lp = new LoginPage();
				lp.doLogin(data.get("userName"),data.get("password"));
			
          

		}
	
	@Test(priority = 3,dataProviderClass = Utilities.class,dataProvider = "dp") 
	  public void gotoCRMPortalAndCreateAnAccount(Hashtable<String, String>data) { 
		System.out.println("TC3-gotoCRMPortalAndCreateAnAccount");
	/*	HomePage hp = new HomePage();
		hp.launchBroswer();
		hp.goToSignIn();
		LoginPage lp = new LoginPage();
		lp.doLogin(data.get("userName"),data.get("password"));*/
	   AppPage ap=new AppPage();
	   ap.goToCRM();
	   Page.tm.goToAccounts(); 
		
	  
	  }
	  
	  /*

	  @Test(priority=4,dataProviderClass =Utilities.class,dataProvider="dp")
	  public void searhCRM(Hashtable<String,String> cc) {
		  
		  try {
			SearchPage sp= new SearchPage();
			  sp.searchAccounts(cc.get("serachValue"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
				System.out.println("Try part get exception therfore Reinilize the new driver seeion and relaunch the browser");
		}
		  
		  
	  }
	*/
	
}
