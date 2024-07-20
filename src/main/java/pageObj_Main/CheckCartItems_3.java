package pageObj_Main;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObj_Base.pageObjBaseclass;

public class CheckCartItems_3 extends pageObjBaseclass {

	public CheckCartItems_3(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = ("//div[@class='cartSection'] //h3"))
	public List<WebElement> cart_Products;

	@FindBy(xpath = ("//*[contains(text(),'Checkout')]"))
	public WebElement checkout_Btn;


	// Methods
	public void myCartProducts() {
		for (WebElement items : cart_Products) {
			System.out.println("The items in cart : " + items.getText());
		}
	}

	public void checkOut() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkout_Btn);
		// checkout_Btn.click();
	}

}
