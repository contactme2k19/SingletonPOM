package com.weirdo.rough;
import com.weirdo.base.Page;
import com.weirdo.pages.AppPage;
import com.weirdo.pages.HomePage;
import com.weirdo.pages.LoginPage;
import com.weirdo.pages.crm.accounts.AccountsPage;
import com.weirdo.pages.crm.accounts.CreateAccountPage;

public class Login {
	public static void main(String[] arg) throws Throwable {
		
		HomePage hp=new HomePage();
		hp.goToSignIn();
	Thread.sleep(8000);
		LoginPage lp=new LoginPage();
		lp.doLogin("d.naveenkumar2@gmail.com", "Test9585778838#");
		AppPage ap=new AppPage();
		ap.goToCRM();
		Thread.sleep(10000);
		Page.tm.goToAccounts();
		Thread.sleep(8000);
		System.out.println("Account page is clicked");
		AccountsPage acp=new AccountsPage();
		acp.gotoCreateAccount();
		System.out.println("Create Account page is clicked");
		CreateAccountPage cap=new CreateAccountPage();
		cap.createAccount("NaveenKumar");
				
		
	}

}
