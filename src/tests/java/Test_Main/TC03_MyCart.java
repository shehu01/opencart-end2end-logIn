package Test_Main;

import org.testng.annotations.Test;

import Tests_Base.Testcase_Baseclass;
import pageObj_Main.CheckCartItems_3;

public class TC03_MyCart extends Testcase_Baseclass {

	@Test(priority = 1)
	public void login() throws InterruptedException {
		super.login();
	}

	@Test(priority = 2)
	public void allitems() {
		CheckCartItems_3 the_cart = new CheckCartItems_3(driver);
		the_cart.myCartProducts();
		the_cart.clickcart();

	}

}
