package pageObj_Main;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage_4 {

	WebDriver driver;

	public OrderPage_4(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators .. Click CC
	@FindBy(xpath = ("(//*[contains(text(),'Credit Card')])[1]"))
	public WebElement card;
	
	//CC details 
	@FindBy(xpath = ("(//*[@type='text']) [1]"))
	public WebElement clearCardNumber;
	@FindBy(xpath = ("(//*[@type='text'])[3]"))
	public WebElement CardName;
	@FindBy(xpath = ("(//*[@type='text'])[3]"))
	public WebElement clearCardName;
	@FindBy(xpath = ("(//*[@type='text'])[6]"))
	public WebElement cardMail;
	@FindBy(xpath = ("(//*[@type='text'])[6]"))
	public WebElement clearcardMail;

	@FindBy(xpath = ("(//input[@class='input txt']) [2]"))
	public WebElement nameOnCardElement;
	@FindBy(xpath = ("(//*[@class='input txt'])[1]"))
	public WebElement Ccvv;

	@FindBy(xpath = ("(//*[@class='input ddl']) [1]"))
	public WebElement ExpiryMonth;

	@FindBy(xpath = ("(//*[@class='input ddl']) [2]"))
	public WebElement ExpiryDay;

	@FindBy(xpath = ("(//*[@type='text'])"))
	List<WebElement> clearNumber;
	@FindBy(xpath = ("(//*[@class='input txt text-validated'])[1]"))  WebElement cardNumber;
	
	//User details
	@FindBy(xpath = ("(//*[@type='text'])[6]"))
	public WebElement UserEmail;
	@FindBy(xpath = (""))
	public WebElement EnterLand;
	@FindBy(xpath = ("(//*[@class='input txt text-validated'])[2]"))
	public WebElement Ship_Country;
	@FindBy(xpath = ("(//*[@class='ng-star-inserted']) [5]"))
	public WebElement selectCountry;
	
	//Click Place Order
	@FindBy(xpath = ("//a[contains(.,'Place Order')]"))
	public WebDriver btn_PlaceOrder;
	
	@FindBy(xpath = ("//a[contains(.,'Place Order')]"))
	public WebElement btn_PlaceOrder1;


	// Methods
	public void ClickCard() {
		card.click();
	}
	public void Card_Num(String Number) { cardNumber.sendKeys(Number);
	}

	public void NumberClear() {clearNumber.clear();

	}

	public void clearance() {
		clearCardNumber.clear();
	}
	public void clearance2() {
		clearCardName.clear();
	}
	public void CardName (String Name) { CardName.sendKeys(Name);
	}

	public void CVV(String cvv) {
		Ccvv.sendKeys(cvv);
	}

	public void ccExpDay() {ExpiryDay.click();
	}
	public void ccExpMonth() { ExpiryMonth.click();
	}
	
	public void mailClearance() {
		clearcardMail.clear();

	}
	public void Email(String mail) { UserEmail.sendKeys(mail);
	}

	public void ilu(String country) { Ship_Country.sendKeys(country);
	}
	public void optnLand() { EnterLand.click();
	}

	public void optnCountry() {
		selectCountry.click();
	}


	// public void placeOrder(WebDriver drive) { btn_PlaceOrder.);

	// }

	public void placeOrder() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn_PlaceOrder1);
		// btn_PlaceOrder1.click();
	}//

	
	
	
	
	
}
