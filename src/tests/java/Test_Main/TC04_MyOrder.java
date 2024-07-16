package Test_Main;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Tests_Base.Testcase_Baseclass;
import pageObj_Main.OrderPage_4;

public class TC04_MyOrder extends Testcase_Baseclass {

	@Test(priority = 8)
	public void Email() {
		OrderPage_4 usereMail = new OrderPage_4(driver);
		usereMail.mailClearance();
		usereMail.Email(read.getProperty("User_Email"));
	}

	@Test(priority = 9)
	public void ccCard() {
		OrderPage_4 cc = new OrderPage_4(driver);
		cc.ClickCard();

		OrderPage_4 CardUserName = new OrderPage_4(driver);
		CardUserName.clearance2();
		CardUserName.CardName(read.getProperty("Holder_Name"));

		OrderPage_4 ccNumber = new OrderPage_4(driver);
		ccNumber.clearance();
		ccNumber.Card_Num(read.getProperty("CardNumber"));

	}

	@Test(priority = 10)
	public void CMonth() {
		OrderPage_4 CMonth = new OrderPage_4(driver);
		CMonth.ccExpMonth();
		Select time2 = new Select(CMonth.ExpiryMonth);
		time2.selectByVisibleText("12");

		OrderPage_4 Cday = new OrderPage_4(driver);
		Cday.ccExpDay();
		Select time = new Select(Cday.ExpiryDay);
		time.selectByVisibleText("25");
	}

	@Test(priority = 11)
	public void cardCVV() throws InterruptedException {
		OrderPage_4 cvvNumber = new OrderPage_4(driver);
		cvvNumber.CVV(read.getProperty("cvvNumber"));

		OrderPage_4 land = new OrderPage_4(driver);
		land.ilu(read.getProperty("Country"));
		land.optnCountry();

		OrderPage_4 clickOrder = new OrderPage_4(driver);
		Thread.sleep(2000);
		clickOrder.placeOrder();
	}

}
