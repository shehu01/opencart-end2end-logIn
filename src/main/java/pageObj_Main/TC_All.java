package pageObj_Main;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Tests_Base.Testcase_Baseclass;

public class TC_All {
	public WebDriver driver;
	public Properties read;

	@BeforeClass
	public void start() throws IOException {
		FileReader shehureader = new FileReader("./src/resources/java/config.properties");
		read = new Properties();
		read.load(shehureader);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get(read.getProperty("AppURL"));
		System.out.println(driver.getTitle());
	}

	// Login credentials TC1
	@Test(priority = 1)
	public void username() throws InterruptedException, IOException {
		Thread.sleep(2000);
		LoginPage_1 malo = new LoginPage_1(driver);
		malo.Username(read.getProperty("User_Email"));
		malo.Password(read.getProperty("User_Password"));
		malo.LogIn();

		LoginPage_1 home = new LoginPage_1(driver);
		Thread.sleep(2000);
		home.msgConfirm();
	}

	// TC 2
	@Test(priority = 3)
	public void cart() {
		try {
			AddtoCart_2 pick = new AddtoCart_2(driver);
			// Thread.sleep(1000);
			pick.additems();

		} catch (Exception e) {
			System.out.println("TC002 was not executed");
		}
	}

	@Test(priority = 4)
	public void clickCart() throws InterruptedException {
		AddtoCart_2 klick = new AddtoCart_2(driver);
		klick.Cart_btn();
	}

	@Test(priority = 5)
	public void confirm() {
		AddtoCart_2 MyAcc = new AddtoCart_2(driver);
		MyAcc.myAccount();
	}

	// TC 3
	@Test(priority = 6)
	public void allitems() {
		CheckCartItems_3 the_cart = new CheckCartItems_3(driver);
		the_cart.myCartProducts();
	}

	@Test(priority = 7)
	public void Checkout() throws InterruptedException {
		CheckCartItems_3 CheckOut = new CheckCartItems_3(driver);
		Actions scroll = new Actions(driver);Thread.sleep(2000);
		scroll.scrollByAmount(221, 530).perform();
		CheckOut.checkOut();
	}

	// TC 4
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
		time2.selectByVisibleText(read.getProperty("cardExpiryMonth"));

		OrderPage_4 Cday = new OrderPage_4(driver);
		Cday.ccExpDay();
		Select time = new Select(Cday.ExpiryDay);
		time.selectByVisibleText(read.getProperty("card_ExpiryDay"));
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

	public class TC05_OrderConfirmation extends Testcase_Baseclass {

		public void orderConfirm() {
			ComfirmOrder_5 order = new ComfirmOrder_5(driver);
		order.confirmOrder();
		}
	}

	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}



}
