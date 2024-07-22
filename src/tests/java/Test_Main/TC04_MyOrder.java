package Test_Main;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Tests_Base.Testcase_Baseclass;
import pageObj_Main.AddtoCart_2;
import pageObj_Main.CheckCartItems_3;
import pageObj_Main.OrderPage_4;


@Listeners(customListener.Listeners.class)
public class TC04_MyOrder extends Testcase_Baseclass {

	@BeforeClass
	public void login() throws InterruptedException {
		super.login();
	}

	@Test(priority = 2)
	public void Email() throws InterruptedException {

		AddtoCart_2 pick = new AddtoCart_2(driver);
		Thread.sleep(2000);
		pick.additems();
		pick.Cart_btn();

		CheckCartItems_3 CheckOut = new CheckCartItems_3(driver);
		CheckOut.myCartProducts();
		Thread.sleep(2000);
		CheckOut.checkOut();
		Thread.sleep(2000);

		OrderPage_4 usereMail = new OrderPage_4(driver);
		usereMail.mailClearance();
		usereMail.Email(read.getProperty("User_Email"));
		usereMail.ClickCard();
		usereMail.clearance2();
		usereMail.CardName(read.getProperty("Holder_Name"));
		usereMail.clearance();
		usereMail.Card_Num(read.getProperty("CardNumber"));
		usereMail.ccExpMonth();

		Select time2 = new Select(usereMail.ExpiryMonth);
		time2.selectByVisibleText("12");
		usereMail.ccExpDay();

		Select time = new Select(usereMail.ExpiryDay);
		time.selectByVisibleText("25");
		usereMail.CVV(read.getProperty("cvvNumber"));

		Thread.sleep(2000);
		usereMail.ilu(read.getProperty("Country"));
		usereMail.optnCountry();
		Thread.sleep(2000);
		usereMail.placeOrder();
	}

}
