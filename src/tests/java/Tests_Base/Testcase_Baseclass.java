package Tests_Base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObj_Main.LoginPage_1;

public class Testcase_Baseclass {
	public WebDriver driver;
	public Properties read;
	public LoginPage_1 malo;

	@BeforeClass
	public void start() throws IOException {
		FileReader shehureader = new FileReader(
				"//C:\\Users\\Abdul\\eclipse-workspace\\End2End\\src\\resources\\java\\config.properties");
		read = new Properties();
		read.load(shehureader);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get(read.getProperty("AppURL"));
		System.out.println(driver.getTitle());
	}

	// Reusable for login in all TC
	public void login() throws InterruptedException {
		LoginPage_1 malo = new LoginPage_1(driver);
		malo.Username(read.getProperty("User_Email"));
		malo.Password(read.getProperty("User_Password"));
		malo.LogIn();
		// Confirm Login was successful
		Thread.sleep(2000);
		malo.msgConfirm();
	}

	// Reusable to go back
	public void goback() {
		driver.navigate().back();
	}

	public void Wait(By waiting) {
		WebDriverWait duro = new WebDriverWait(driver, Duration.ofSeconds(5));
		duro.until(ExpectedConditions.visibilityOfElementLocated(waiting));
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}


	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}


//./src/resources/java/config.properties
}
