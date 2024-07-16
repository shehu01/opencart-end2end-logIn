package SeleniumTest.End2End;

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

//import System.out;
import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.allReusables.ReUsableWait;
import selenium.pageObject.ItemCatalogPage;
import selenium.pageObject.LandingPage;
public class PlaceOrder1 {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver malo = new ChromeDriver();
	malo.manage().window().maximize();
	System.out.println("The log in page is " + malo.getCurrentUrl()+ "page");
	malo.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	WebDriverWait explicit = new WebDriverWait (malo, Duration.ofSeconds(5));

	//wait.WaitTillelementsappear();
		
	
	
	//User Login to the application
	String Email = "justshehu@yahoo.com" ; String Password = "Malo@12345";
	LandingPage landpage = new LandingPage (malo);
	landpage.Geturl();
	landpage.LoginActions(Email,Password);
	System.out.println("The Customer pager after log in is " + malo.getCurrentUrl());
	
	ItemCatalogPage item = new ItemCatalogPage (malo);
	item.GetItemz();
	ReUsableWait wait = new ReUsableWait (malo);
	
	//User waits till list of Web elements are visible on application
		System.out.println("===========================================");
		List <WebElement> items = malo.findElements(By.cssSelector(".card-body b"));
		for (WebElement trial : items) 
		{
			System.out.println(trial.getText()+" Is added to cart ");
		}
		
	//User Adds items to cart and waits till they are registered
		List <WebElement> itemz = malo.findElements(By.cssSelector(".btn.w-10"));
		for (WebElement AddtoCart : itemz) 
		{
			explicit.until(ExpectedConditions.visibilityOf(AddtoCart)).click();
			explicit.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-6")));
			explicit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).isDisplayed();
			explicit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		}
		
//		Check the cart before exit.
		System.out.println("===========================================");
		System.out.println("The number of items in"+ malo.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).getText());
		malo.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		//Confirm List of items in cart
		System.out.println("===========================================");
		List <WebElement> cartItems = malo.findElements(By.cssSelector(".items h3"));
		for (WebElement selItems : cartItems)
			
		{
			System.out.println(selItems.getText()+" Is in cart");
			Assert.assertEquals(true,selItems.isDisplayed());
		}
		
		//scroll to the buttom of the apllication to check out
		WebElement checkout = malo.findElement(By.xpath("(//*[@class='btn btn-primary'])[5]"));
		Actions scroll = new Actions (malo);
		scroll.scrollToElement(checkout).build().perform();
		
		//User will fill details to place Orders
		malo.findElement(By.cssSelector(".totalRow button")).click();
		malo.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Nigeria");
		explicit.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ta-item.list-group-item"))).click();
		
		WebElement month = malo.findElement(By.cssSelector(".input.ddl"));
		Select mont = new Select (month);
		mont.selectByVisibleText("10");
		
		WebElement day = malo.findElement(By.xpath("(//*[@class='input ddl'])[2]"));
		Select days = new Select (day);
		days.selectByIndex(22);
		
		malo.findElement(By.xpath("(//*[@class='input txt'])[1]")).sendKeys("765");
		malo.findElement(By.xpath("(//*[@class='input txt'])[2]")).sendKeys("Adejoke Lover");
		
		//Scroll to the footer to and click on place Order
		WebElement placeOrder = malo.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted"));
		Actions order = new Actions (malo);
		order.moveToElement(placeOrder).build().perform();
		malo.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		//Varify the Goodbye message is displayed.
		System.out.println("===========================================");
		//System.out.println(malo.findElement(By.cssSelector(".hero-primary")).getText());
		String goodbye = malo.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(goodbye, "THANKYOU FOR THE ORDER.");
		System.out.println(malo.getCurrentUrl());
		
		//WebElement tenny = items.stream().filter(item ->item.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		//tenny.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
		
		
	Thread.sleep(2000);
	malo.quit();
	}

}
