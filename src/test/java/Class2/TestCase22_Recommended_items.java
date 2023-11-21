package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Recommended_items;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase22_Recommended_items {
	private WebDriver driver;
	private Recommended_items recommended_items;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		recommended_items = new Recommended_items(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void scroll() {
		recommended_items.scroll();
	}

	@Test(priority = 2)
	public void testrecommendedVisibility() {
		boolean isrecommendedVisible = recommended_items.isrecommendedVisible();
		Assert.assertTrue(isrecommendedVisible, "RECOMENDED PRODUCTS NOT VISIBLE");
	}

	@Test(priority = 3)
	public void addingtocart() {
		recommended_items.addtocarts();
		recommended_items.clickcart();

	}

	@Test(priority = 4)
	public void testaddeditemsVisibility() {
		boolean isaddesitemsVisible = recommended_items.isaddesitemsVisible();
		Assert.assertTrue(isaddesitemsVisible, "ADDED ITEMS NOT VISIBLE");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}