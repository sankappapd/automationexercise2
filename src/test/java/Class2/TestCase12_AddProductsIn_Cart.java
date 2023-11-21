package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.AddProductsIn_Cart;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase12_AddProductsIn_Cart {
	private WebDriver driver;
	private AddProductsIn_Cart addProductsIn_Cart;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		addProductsIn_Cart = new AddProductsIn_Cart(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = addProductsIn_Cart.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2,dependsOnMethods = "testHomePageVisibility")
	public void productselect() {
		addProductsIn_Cart.productsclick();
	}

	@Test(priority = 3, dependsOnMethods = "productselect")
	public void productaddtocart() {
		addProductsIn_Cart.addtocartitem();
		addProductsIn_Cart.continuetoadd();
		addProductsIn_Cart.continuetoaddcart2();
		addProductsIn_Cart.viewcartclick();
	}

	@Test(priority = 4, dependsOnMethods = "productaddtocart")
	public void testnameVisibility() {
		boolean productsverify = addProductsIn_Cart.productsverify();
		Assert.assertTrue(productsverify, "NAME IS NOT VISIBLE");
	}

	@Test(priority = 4, dependsOnMethods = "testnameVisibility")
	public void testproduct1rateVisibility() {
		boolean products1rateverify = addProductsIn_Cart.products1rateverify();
		Assert.assertTrue(products1rateverify, "PRODUCT IS NOT VISIBLE");

	}

	@Test(priority = 5, dependsOnMethods = "testproduct1rateVisibility")
	public void testproducs1quantityVisibility() {
		boolean products1quantityverify = addProductsIn_Cart.products1quantityverify();
		Assert.assertTrue(products1quantityverify, "QUANTITY NOT CORRECT");

	}

	@Test(priority = 6, dependsOnMethods = "testproducs1quantityVisibility")
	public void testproduct1totalpriceVisibility() {
		boolean products1totalpriceverify = addProductsIn_Cart.products1totalpriceverify();
		Assert.assertTrue(products1totalpriceverify, "TOTTAL PRICE IS NOT CORRECT");

	}

	@Test(priority = 7, dependsOnMethods = "testproduct1totalpriceVisibility")
	public void testname2Visibility() {
		boolean products2verify = addProductsIn_Cart.products2verify();
		Assert.assertTrue(products2verify, "NAME OF ITEM IS NOT CORRECT");
	}

	@Test(priority = 4, dependsOnMethods = "testname2Visibility")
	public void testproduct2rateVisibility() {
		boolean products2rateverify = addProductsIn_Cart.products2rateverify();
		Assert.assertTrue(products2rateverify, "ITEM RATE IS NOT CORRECT");

	}

	@Test(priority = 4, dependsOnMethods = "testproduct2rateVisibility")
	public void testproduct2quantityVisibility() {
		boolean products2quantityverify = addProductsIn_Cart.products2quantityverify();
		Assert.assertTrue(products2quantityverify, "PRODUCT QUANTITY IS NOT CORRECT");

	}

	@Test(priority = 4, dependsOnMethods = "testproduct2quantityVisibility")
	public void testproduct2totalpriceVisibility() {
		boolean products1tota2priceverify = addProductsIn_Cart.products1tota2priceverify();
		Assert.assertTrue(products1tota2priceverify, "TOTAL PRICE IS NOT CORRECT");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
