package testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Rahu.allReusables.ReUsables;
import RahulPageObjPkg.LandingPage;


public class RahulTC001_LogIn extends ReUsables
{
	WebDriver driver;

	public RahulTC001_LogIn(WebDriver driver) {
		super(driver);
	}

		@Test (priority = 1)
	public void username()
		{
			LandingPage man = new LandingPage(driver);
			man.LoginActions("justshehu@yahoo.com", "Malo@12345");
		}
		
		
		@Test(priority = 2)
		public void HomeBtn() {
			LandingPage malo = new LandingPage(driver);
			malo.button();
		}
		


		/*
		 * @AfterClass public void teardown() throws InterruptedException {
		 * 
		 * Thread.sleep(2000); driver.close(); }
		 */
		
	}


