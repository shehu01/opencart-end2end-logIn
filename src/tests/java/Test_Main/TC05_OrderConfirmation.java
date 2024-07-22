package Test_Main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Tests_Base.Testcase_Baseclass;
import pageObj_Main.ComfirmOrder_5;

public class TC05_OrderConfirmation extends Testcase_Baseclass {

	@BeforeClass
	public void login() throws InterruptedException {
		super.login();
	}

	@Test
	public void orderConfirm() {
		ComfirmOrder_5 order = new ComfirmOrder_5(driver);
		order.confirmOrder();
	}

}


