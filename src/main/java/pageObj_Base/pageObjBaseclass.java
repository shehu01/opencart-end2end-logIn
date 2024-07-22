package pageObj_Base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageObjBaseclass {

	public WebDriver driver;

	public pageObjBaseclass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
