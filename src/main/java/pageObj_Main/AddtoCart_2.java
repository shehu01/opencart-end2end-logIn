package pageObj_Main;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddtoCart_2 {

	WebDriver driver;

	public AddtoCart_2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}




	// Locators
	@FindBy(css = (".btn.w-10"))
	List<WebElement> items;

	@FindBy(xpath = ("(//button[contains(.,'Cart')]) [1]"))
	WebElement cart;

	@FindBy(css = ("[class*='heading cf'] h1"))
	WebElement MyAccount;

	@FindBy(xpath = "(//input[@name='search'])[2]")
	WebElement searchboxElement;


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

	//
	public void searchItem(String item) {
		searchboxElement.sendKeys(item);
		searchboxElement.sendKeys(Keys.ENTER);
	}

}
