package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Verify_ProductQuantity;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase13_Verify_ProductQuantity {
	private WebDriver driver;
	private Verify_ProductQuantity verify_ProductQuantity;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		verify_ProductQuantity = new Verify_ProductQuantity(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = verify_ProductQuantity.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2, dependsOnMethods = "testHomePageVisibility")
	public void productselect() {
		verify_ProductQuantity.productsclick();

	}

	@Test(priority = 3, dependsOnMethods = "productselect")
	public void testproductdetailsVisibility() {
		boolean isviewproductVisible = verify_ProductQuantity.isviewproductVisible();
		Assert.assertTrue(isviewproductVisible, "PRODUCT DETAILS NOT SHOWN");

	}

	@Test(priority = 4, dependsOnMethods = "testproductdetailsVisibility")
	public void quantity() {
		verify_ProductQuantity.clickIncreaseButton("4");
	}

	@Test(priority = 5, dependsOnMethods = "quantity")
	public void addcartvisible() {
		verify_ProductQuantity.addcartbutton();
		verify_ProductQuantity.viewcartitem();

	}

	@Test(priority = 6, dependsOnMethods = "addcartvisible")
	public void itemVisibilityincart() {
		boolean isitemsVisible = verify_ProductQuantity.isitemsVisible();
		Assert.assertTrue(isitemsVisible, "PRODUCT DETAILS NOT SHOWN");

	}

	@Test(priority = 7, dependsOnMethods = "itemVisibilityincart")
	public void itemquantityVisibilityincart() {
		boolean isitemsquantityVisible = verify_ProductQuantity.isitemsquantityVisible();
		Assert.assertTrue(isitemsquantityVisible, "PRODUCT DETAILS NOT SHOWN");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
