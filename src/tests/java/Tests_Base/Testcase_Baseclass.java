package Tests_Base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Testcase_Baseclass {
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


	public void Wait(By waiting) {
		WebDriverWait duro = new WebDriverWait(driver, Duration.ofSeconds(5));
		duro.until(ExpectedConditions.visibilityOfElementLocated(waiting));
	}


	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}



}
