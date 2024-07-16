package pageObj_Main;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import pageObj_Base.pageObjBaseclass;

public class LoginPage_1 extends pageObjBaseclass {
	public LoginPage_1(WebDriver driver) {
		super(driver);
	}



	@FindBy(css = ("input[id='userEmail']"))
	WebElement userNamElement;

	@FindBy(css = ("input[id='userPassword']"))
	WebElement passwordElement;

	@FindBy(css = ("input[id='login']"))
	WebElement logInbtnElement;

	@FindBy(xpath = ("//button[contains(.,'HOME')]"))
	WebElement homElement;

	///////////////////////////////////////
	///////////////////////////////////////

	public void Username(String Name) {
		userNamElement.sendKeys(Name);
	}

	public void Password(String Passwd) {
		passwordElement.sendKeys(Passwd);
	}

	public void LogIn() {
		logInbtnElement.click();
	}

	public void msgConfirm() {
		String confirm = homElement.getText();
		Assert.assertEquals(confirm, "HOME");
		System.out.println(confirm + " page is displayed Successfuly");


	}


}

