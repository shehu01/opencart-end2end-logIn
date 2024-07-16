
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class UntouchedPlaceOrder {
	
	
	// 2. User Login to application
public static void LogIn (WebDriver malo) throws InterruptedException
  {
	Thread.sleep(2000); malo.findElement(By.cssSelector("input[id='userEmail']")).sendKeys("justshehu@yahoo.com");
	Thread.sleep(2000); malo.findElement(By.cssSelector("input[id='userPassword']")).sendKeys("Malo@12345");
	Thread.sleep(2000); malo.findElement(By.cssSelector("input[id='login']")).click();
	System.out.println("The Customer page after log in  is " + malo.getCurrentUrl());
  }


	//3. User waits till list of Web elements are visible on application
public static void webElement (WebDriver malo)
{
	System.out.println("===========================================");
	WebDriverWait explicit = new WebDriverWait (malo, Duration.ofSeconds(5));
	explicit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body b")));
	List <WebElement> items = malo.findElements(By.cssSelector(".card-body b"));
	for (WebElement trial : items) 
{
		System.out.println(trial.getText()+" Is added to cart ");
	}
}



	//4. User Adds items to cart and waits till they are registered
	public static void addtoCart(WebDriver malo) throws InterruptedException
 {
		WebDriverWait wait = new WebDriverWait(malo, Duration.ofSeconds(8));
		List<WebElement> itemz = malo.findElements(By.cssSelector(".btn.w-10"));

		// itemz.stream().filter(item ->
		// item.findElement(By.cssSelector("b")).getText().equals("Zara Coat"));

		for (WebElement AddtoCart : itemz)
	{
		// Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(AddtoCart)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	}
 }
	
	//5. Check the cart before exit.
public static void checkCart (WebDriver malo)
{
	System.out.println("===========================================");
	System.out.println("The number of items in"+ malo.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).getText());
	malo.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
}


//6. Confirm List of items in cart
public static void cartItemsList (WebDriver malo)
{
System.out.println("===========================================");
List <WebElement> cartItems = malo.findElements(By.cssSelector(".items h3"));
for (WebElement selItems : cartItems)
	
{
	System.out.println(selItems.getText()+" Is in cart");
	Assert.assertEquals(true,selItems.isDisplayed());
}
}


	//7. scroll to the buttom of the apllication to check out
public static void toCheckOut (WebDriver malo)
{
WebElement checkout = malo.findElement(By.xpath("(//*[@class='btn btn-primary'])[5]"));
Actions scroll = new Actions (malo);
scroll.scrollToElement(checkout).build().perform();
malo.findElement(By.cssSelector(".totalRow button")).click();
}


	//8. User will fill details to place Orders
public static void fillOrderform (WebDriver malo)
{
	WebDriverWait explicit = new WebDriverWait (malo, Duration.ofSeconds(5));

	malo.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Nigeria");
	explicit.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ta-item.list-group-item"))).click();

	malo.findElement(By.xpath("(//*[@class='input txt text-validated']) [1]")).clear();
	malo.findElement(By.xpath("(//*[@class='input txt text-validated']) [1]")).sendKeys("417631012789");

	WebElement month = malo.findElement(By.cssSelector(".input.ddl"));
	Select mont = new Select (month);
	mont.selectByVisibleText("10");

	WebElement day = malo.findElement(By.xpath("(//*[@class='input ddl'])[2]"));
	Select days = new Select (day);
	days.selectByIndex(22);

	malo.findElement(By.xpath("(//*[@class='input txt'])[1]")).sendKeys("765");
	malo.findElement(By.xpath("(//*[@class='input txt'])[2]")).sendKeys("Adejoke Lover");
}	


	//9. Scroll to the footer to and click on place Order
public static void clickPlaceOrder (WebDriver malo)
  {
	WebElement placeOrder = malo.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted"));
	Actions order = new Actions (malo);
	order.moveToElement(placeOrder).build().perform();
	malo.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
  }


	//10. Varify the Goodbye message is displayed.

public static void verifyMessage (WebDriver malo) throws InterruptedException
{
	System.out.println("===========================================");
	System.out.println(malo.findElement(By.cssSelector(".hero-primary")).getText());
	String goodbye = malo.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertEquals(goodbye, "THANKYOU FOR THE ORDER.");
	System.out.println(malo.getCurrentUrl());

//WebElement tenny = items.stream().filter(item ->item.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//tenny.findElement(By.cssSelector(".card-body button:last-of-type")).click();

	Thread.sleep(2000);
	malo.quit();
}



//1/ Main Method for- 	Application Set up
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver malo = new ChromeDriver();
	malo.manage().window().maximize();
	malo.get("https://rahulshettyacademy.com/client");
	System.out.println("The log in page is " + malo.getCurrentUrl());
	malo.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	WebDriverWait explicit = new WebDriverWait (malo, Duration.ofSeconds(5));
	
	
	//Created Methods
	LogIn(malo);
	// webElement(malo);
	addtoCart(malo);
	checkCart(malo);
	cartItemsList(malo);
	toCheckOut(malo);
	fillOrderform(malo);
//	clickPlaceOrder (malo);
//	verifyMessage (malo);
	
	
}

}
