package Rahu.allReusables;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;


public class ReUsables {
		WebDriver driver;

		// Contructor
	public ReUsables(WebDriver driver) {
		this.driver = driver;
	}	

	@BeforeClass
	void SetUp() {
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

	}
		
	// Till Visibility of WebElements
	public void Waitelementsappear(By waits) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(waits));
		}

		// Till Element is invisible
		public void elementDissappear(By vanish) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(vanish));
		}

	}

