package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Search_Products;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase9_SerachProducts {
	private WebDriver driver;
	private Search_Products search_Products;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		search_Products = new Search_Products(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = search_Products.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2)
	public void productselect() {
		search_Products.productsclick();
	}

	@Test(priority = 3)
	public void isproductsnameVisibility() {
		boolean isproductsVisible = search_Products.isproductsVisible();
		Assert.assertTrue(isproductsVisible, "NAME NOT VISIBLE.");
	}

	@Test(priority = 4)
	public void search1() {
		search_Products.Searchitem("jeans");
		search_Products.searchclick();
	}

	@Test(priority = 4)
	public void issearchedproductVisibility() {
		boolean issearchedproductsVisible = search_Products.issearchedproductsVisible();
		Assert.assertTrue(issearchedproductsVisible, "SEARCHED PRODUCTS NOT VISIBLE.");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
