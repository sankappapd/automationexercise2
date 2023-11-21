package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Remove_Products;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClase17_Remove_Products {
	 private WebDriver driver;
	    private Remove_Products remove_Products;

	    @BeforeTest
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get("https://automationexercise.com/"); // Replace with your login page URL
	        remove_Products = new Remove_Products(driver); // Corrected initialization
	    }

	    @Test
	    public void Homepage() {
	        remove_Products.verifyHomePageIsVisible();
	        
	       }
	    
	    @Test(dependsOnMethods="Homepage")
	    public void productaddtocart() {
	    	remove_Products.addtocartitem();
	    	remove_Products.viewcartclick();
	    	}
	    
	    @Test(dependsOnMethods="productaddtocart")
	    public void removefromcart() {
	    	remove_Products.removeitems();
	    	}
	    
	    @Test(dependsOnMethods="removefromcart")
	    public void removeverify() {
	        remove_Products.removedsuccess();
	        
	       }
	    
	    
	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	        
	    }
	    
	    
	    
	    
	    
	    
}
