package pageObj_Main;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import pageObj_Base.pageObjBaseclass;

public class AddtoCart_2 extends pageObjBaseclass {

	public AddtoCart_2(WebDriver driver) {
		super(driver);
	}




	// Locators
	@FindBy(css = (".btn.w-10"))
	List<WebElement> items;

	@FindBy(xpath = ("(//button[contains(.,'Cart')]) [1]"))
	WebElement cart;

	@FindBy(css = ("[class*='heading cf'] h1"))
	WebElement MyAccount;


	// Methods
	public void additems() throws InterruptedException {
		for (WebElement choose : items) {
			Thread.sleep(3000);
			choose.click();
		}
	}

	public void Cart_btn() throws InterruptedException {
		Thread.sleep(3000);
		cart.click();
	}

	public void myAccount() {
		Assert.assertEquals("My Cart", MyAccount.getText());

	}

}
