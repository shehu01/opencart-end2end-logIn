package rsatests;

import org.testng.annotations.Test;

import Tests_Base.Testcase_Baseclass;
import pageObj_Main.LoginPage_1;

public class AddToCartTest extends Testcase_Baseclass {

	LoginPage_1 login;

	@Test
	public void addToCart() {
		login = new LoginPage_1(driver);
		login.Username("");
		login.Password("");
		login.LogIn();
	}

}
