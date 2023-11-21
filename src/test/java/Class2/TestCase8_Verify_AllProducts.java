package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Verify_AllProducts;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase8_Verify_AllProducts {
	private WebDriver driver;
	private Verify_AllProducts verify_AllProducts;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); 
		verify_AllProducts = new Verify_AllProducts(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = verify_AllProducts.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2)
	public void productselect() {
		verify_AllProducts.productsclick();
		
	}

	@Test(priority = 3)
	public void isproductsnameVisibility() {
		boolean isproductsVisible = verify_AllProducts.isproductsVisible();
		Assert.assertTrue(isproductsVisible, "NAME NOT VISIBLE.");
	}

	@Test(priority = 4)
	public void firstproductview() {
		verify_AllProducts.firstproductname();
	}

	@Test(priority = 5)
	public void isproductsbrandVisibility() {
		boolean isproductnameVisible = verify_AllProducts.isproductnameVisible();
		Assert.assertTrue(isproductnameVisible, "PRODUCT NAME NOT VISIBLE");
	}

	@Test(priority = 6)
	public void isproductscategoryVisibility() {
		boolean isproductscategoryVisible = verify_AllProducts.isproductscategoryVisible();
		Assert.assertTrue(isproductscategoryVisible, "CATEGORY NOT VISIBLE");
	}

	@Test(priority = 7)
	public void isproductsrateVisibility() {
		boolean isproductsrateVisible = verify_AllProducts.isproductsrateVisible();
		Assert.assertTrue(isproductsrateVisible, "RATE NOT VISIBLE");
	}

	@Test(priority = 8)
	public void isproductsavailabileVisibility() {
		boolean isproductsavailableVisible = verify_AllProducts.isproductsavailableVisible();
		Assert.assertTrue(isproductsavailableVisible, "AVAILABILITY NOT VISIBLE");
	}

	@Test(priority = 9)
	public void isproductsconditionVisibility() {
		boolean isproductsconditionVisible = verify_AllProducts.isproductsconditionVisible();
		Assert.assertTrue(isproductsconditionVisible, "CONDITION NOT VISIBLE");
	}

	@Test(priority = 10)
	public void isproductsVisibility() {
		boolean isproductsbrandVisible = verify_AllProducts.isproductsbrandVisible();
		Assert.assertTrue(isproductsbrandVisible, "BRAND NOT VISIBLE");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
