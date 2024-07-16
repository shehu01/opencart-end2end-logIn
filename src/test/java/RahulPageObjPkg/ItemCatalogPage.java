
package RahulPageObjPkg;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Rahu.allReusables.ReUsables;
public class ItemCatalogPage  extends ReUsables {

	WebDriver driver;
		public ItemCatalogPage(WebDriver driver) 
		{
			super (driver);
		}
		
		@FindBy(css=".btn.w-10")
		List<WebElement> btn_AddtoCart;

		@FindBy(css = "#toast-container")
		WebElement toast;

		@FindBy(css = ".ng-tns-c31-6")
		WebElement tillinvisible;
		

		
//		public List<WebElement> GetItemz()
//		{
//			Waitelementsappear();
//			return btn_AddtoCart;
//		}
//		
//
//		public void additem()
//		{
//			
//			Waitelementsappear(toast);
//			
//		}

		
	}







