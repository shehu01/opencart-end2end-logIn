package Test_Main;

import org.testng.annotations.Test;

import Tests_Base.Testcase_Baseclass;
import pageObj_Main.AddtoCart_2;

public class TC02_AddToCart extends Testcase_Baseclass {


	// Called from TC01. To complete this step
	@Test(priority = 1)
	public void login() throws InterruptedException {
		super.login();
	}

	// Search Items
	@Test(priority = 2)
	public void searchietm() throws InterruptedException {
		AddtoCart_2 search = new AddtoCart_2(driver);
		search.searchItem(read.getProperty("search_item"));
		Thread.sleep(2000);
		super.goback();
	}
	
	@Test(priority = 3)
	public void cart() throws InterruptedException {
		AddtoCart_2 pick = new AddtoCart_2(driver);
		pick.additems();

		AddtoCart_2 klick = new AddtoCart_2(driver);
		klick.Cart_btn();
		klick.myAccount();
}
}
