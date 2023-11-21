package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Remove_Products {
	 private WebDriver driver;
	    WebDriverWait wait;

	    public Remove_Products(WebDriver driver) {
	        this.driver = driver;
	    
	    }
	    
	 private By homepage = By.xpath("//a[normalize-space()='Home']");
	  private By addtocart = By.xpath("(//a[@data-product-id=\"1\"][@class=\"btn btn-default add-to-cart\"])[1]");
	  private By viewcart = By.xpath("//*[contains(text(),'View Cart')]");
	  private By remove = By.xpath("//i[@class='fa fa-times']");
	  private By verifyremove = By.xpath("//*[contains(text(),'Cart is empty!')]");
	  
	  
	  
	  
	  public boolean isHomepagevisible() {
			return driver.findElement(homepage).isDisplayed();
		}

		public void verifyHomePageIsVisible() {
			Assert.assertTrue(isHomepagevisible(), "Home page is not visible.");
		}
		public void addtocartitem() {
		   	driver.navigate().refresh();
		    WebElement clickadd=	driver.findElement(addtocart);
		    clickadd.click();
		    }
		   
		public void viewcartclick() {
		    WebElement clickviewcart=	driver.findElement(viewcart);
		    clickviewcart.click();
		}
		public void removeitems() {
		   	//driver.navigate().refresh();
		    WebElement clickremove=	driver.findElement(remove);
		    clickremove.click();
		    }
		
		  public boolean removedsuccess() {
				return driver.findElement(verifyremove).isDisplayed();
			}
		  
		  
		
}
