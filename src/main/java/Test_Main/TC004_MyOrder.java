package Test_Main;

import org.testng.annotations.Test;

import Tests_Base.TC_BaseClass;
import pageObj_Main.OrderPage_4;

public class TC004_MyOrder extends TC_BaseClass {

	@Test(priority = 1)
	public void ccCard() {
		OrderPage_4 cc = new OrderPage_4(driver);
		cc.ClickCard();
	}

	@Test(priority = 2)
	public void allitems() {
		OrderPage_4 ccNumber = new OrderPage_4(driver);
		ccNumber.Card_Num(read.getProperty(""));
		ccNumber.CVV(read.getProperty(""));
	}

	public void userMail() {
		OrderPage_4 mail = new OrderPage_4(driver);
		mail.Email(read.getProperty(""));
	}

	public void Land() {
		OrderPage_4 land = new OrderPage_4(driver);
		land.ilu(read.getProperty(""));
	}

	public void Cday() {
		OrderPage_4 ExpDay = new OrderPage_4(driver);
		ExpDay.CVV("456");

		OrderPage_4 ExpMonth = new OrderPage_4(driver);
		ExpMonth.CVV("456");
	}


	public void PlaceOrdrButton() {
		OrderPage_4 clickOrder = new OrderPage_4(driver);
		clickOrder.placeOrder();
	}

}
