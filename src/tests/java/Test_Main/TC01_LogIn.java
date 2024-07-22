package Test_Main;

import java.io.IOException;

import org.testng.annotations.Test;

import Tests_Base.Testcase_Baseclass;
import pageObj_Main.LoginPage_1;


public class TC01_LogIn extends Testcase_Baseclass {
	// WebDriver driver; This should never be here, else
	// It ll not execute bcos ist already called from
// base Test class.

	@Test(priority = 1)
	public void username() throws InterruptedException, IOException {
		// User Signs in with valid credentials.
		LoginPage_1 malo = new LoginPage_1(driver);
		malo.Username(read.getProperty("User_Email"));
		malo.Password(read.getProperty("User_Password"));
		malo.LogIn();

		// Confirm Login was successful
		Thread.sleep(2000);
		malo.msgConfirm();
	}
		
}



