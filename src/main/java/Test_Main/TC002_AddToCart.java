package Test_Main;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Tests_Base.TC_BaseClass;
import pageObj_Main.AddtoCart_2;

public class TC002_AddToCart extends TC_BaseClass {


	WebDriver driver;

	@Test(priority = 1)
	public void cart() {
		try {

		AddtoCart_2 pick = new AddtoCart_2(driver);
		Thread.sleep(2000);
		pick.additems();

	} catch (Exception e) {
		System.out.println("TC002 was not executed");
	}

	}

	@Test(priority = 2)
	public void clickCart() throws InterruptedException {
		AddtoCart_2 klick = new AddtoCart_2(driver);
		klick.Cart_btn();
	}

	@Test(priority = 3)
	public void confirm() {
		AddtoCart_2 MyAcc = new AddtoCart_2(driver);
		MyAcc.myAccount();
	}

}
