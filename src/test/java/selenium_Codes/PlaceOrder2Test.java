package selenium_Codes;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlaceOrder2Test {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver malo = new ChromeDriver();
	malo.get("https://rahulshettyacademy.com/client");
	malo.manage().window().maximize();
	System.out.println("The log in page is " + malo.getCurrentUrl()+ "page");
	malo.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	WebDriverWait explicit = new WebDriverWait (malo, Duration.ofSeconds(5));
	
	//User sign into application
	String Email = "justshehu@yahoo.com"; String Password = "Malo@12345";
	malo.findElement(By.cssSelector("input[type=email]")).sendKeys(Email);
	malo.findElement(By.cssSelector("input[type=password]")).sendKeys(Password);
	malo.findElement(By.cssSelector("input[id='login']")).click();
	System.out.println("Current page Url is .." + malo.getTitle());
	
	List <WebElement> allitems = malo.findElements(By.xpath("//div[@class='py-2 border-bottom ml-3']//label[@for='cat']"));
	for (WebElement items : allitems) 
	{
		System.out.println(items.getText()+ " belongs to the main category");
	}
	
	malo.findElement(By.xpath("(//*[@type='checkbox'])[12]")).click();
	malo.findElement(By.xpath("(//*[@tabindex='0'])[5]")).click();
	Thread.sleep(3000);
	malo.navigate().back();
	
	List <WebElement>  addtocart = malo.findElements(By.xpath("(//button[@style='float: right;'])"));
	
				for (WebElement item : addtocart)
					{
						
						Thread.sleep(3000);
						item.click();
					}
					
					
				//break;
			
	
	
		
	
//	malo.findElement(By.xpath("(//*[@type='checkbox'])[13]")).click();
//	malo.findElement(By.xpath("(//*[@type='checkbox'])[13]")).click();
	
	
	
	
	Thread.sleep(2000);
	//malo.quit();
	}

private static int addtocart() {
	// TODO Auto-generated method stub
	return 0;
}


}
