package Test_Main;

import org.testng.annotations.Test;

import Tests_Base.TC_BaseClass;
import pageObj_Main.CheckCartItems_3;

public class TC003_MyCart extends TC_BaseClass {


	@Test(priority = 2)
	public void allitems() {
		CheckCartItems_3 the_cart = new CheckCartItems_3(driver);
		the_cart.myCartProducts();
	}

	public void Checkout() {
		CheckCartItems_3 CheckOut = new CheckCartItems_3(driver);
		CheckOut.checkOut();
	}

}
