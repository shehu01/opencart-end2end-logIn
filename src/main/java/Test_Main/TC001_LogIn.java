package Test_Main;

import java.io.IOException;

import org.testng.annotations.Test;

import Tests_Base.TC_BaseClass;
import pageObj_Main.LoginPage_1;


public class TC001_LogIn extends TC_BaseClass
{
	// WebDriver driver; This should never be here, else
	// It ll not execute bcos ist already called from
	// base Test class.

		@Test (priority = 1)
		public void username() throws InterruptedException, IOException
		{
			Thread.sleep(2000);
			LoginPage_1 malo = new LoginPage_1 (driver);
			malo.Username(read.getProperty("User_Email"));
			malo.Password(read.getProperty("User_Password"));
			malo.LogIn();
		}
		
		@Test(priority = 2)
		public void HomeBtn() throws InterruptedException {
			 LoginPage_1 home = new LoginPage_1(driver);
				Thread.sleep(2000);
				home.msgConfirm();
		}
	}


