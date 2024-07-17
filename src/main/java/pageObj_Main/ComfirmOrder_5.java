package pageObj_Main;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObj_Base.pageObjBaseclass;
public class ComfirmOrder_5 extends pageObjBaseclass  {


	public ComfirmOrder_5(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ("//*[@class ='hero-primary']"))
	WebElement myOder;

	// Actions
	public void confirmOrder() {
		System.out.println("Order display message: " + myOder.getText());

	}

		
	
}
