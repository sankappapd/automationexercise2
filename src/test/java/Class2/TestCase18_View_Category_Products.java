package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.View_Category_Products;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase18_View_Category_Products {
	private WebDriver driver;
	private View_Category_Products view_Category_Products;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		view_Category_Products = new View_Category_Products(driver); // Corrected initialization
	}

	@Test
	public void Homepage() {
		view_Category_Products.verifyHomePageIsVisible();

	}

	@Test(priority = 1, dependsOnMethods = "Homepage")
	public void womenCategories() {
		view_Category_Products.verifycategoriesIsVisible();
		view_Category_Products.womencategory();
		view_Category_Products.womentops();

	}

	@Test(priority = 2, dependsOnMethods = "womenCategories")
	public void womentopscategory() {
		view_Category_Products.verifyHwomentopsIsVisible();

	}

	@Test(priority = 3, dependsOnMethods = "womentopscategory")
	public void menCategories() {
		view_Category_Products.mencategory();
		view_Category_Products.menjeans();

	}

	@Test(priority = 4, dependsOnMethods = "menCategories")
	public void menjeanscategory() {
		view_Category_Products.verifyHmenjeansIsVisible();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
