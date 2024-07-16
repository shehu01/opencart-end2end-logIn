package RahulPageObjPkg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahu.allReusables.ReUsables;

public class LandingPage extends ReUsables {

		WebDriver malo;
		public LandingPage(WebDriver driver) 
		{
			super (driver);
			this.malo = driver;
			PageFactory.initElements(driver, this);
		}
		
		
		//Locators
		//Page Factory... this method helps to shorten Sytaxes. Create Locators here
		@FindBy(css="input[id='userEmail']") 
		WebElement userEmail;
		
		@FindBy(css="input[id='userPassword']")
		WebElement userPassword;
		
		@FindBy(css="input[id='login']")
		WebElement userClick;

		
		//Actions
		public void LoginActions(String Email, String Password) {
			userEmail.sendKeys(Email);
			userPassword.sendKeys(Password);
		}

		public void button() {
			userClick.click();
		}

		public void Geturl() {
			malo.get("https://rahulshettyacademy.com/client");
		}


}



