package com.weirdo.rough;



import org.testng.annotations.Test;

import com.weirdo.pages.HomePage;
import com.weirdo.pages.LoginPage;
import com.weirdo.testcases.BaseTest;


public class TestFailureWithLisner extends BaseTest{
	
	@Test(priority = 1)
	public void signIntoZohoApp()
	{
		
		
		try {
			HomePage hp=new HomePage();
			hp.goToSignIn();
		    Thread.sleep(8000);
			LoginPage lp=new LoginPage();
			lp.doLogin("d.naveenkumar2@gmail.com", "Test9585778838#");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Assert.assertTrue(true,"TestCase Passed for capture screenshot....");*/
		//Assert.fail("TestcaseFailed and make sure listenr shows the scrnshot");
	
	}

}
