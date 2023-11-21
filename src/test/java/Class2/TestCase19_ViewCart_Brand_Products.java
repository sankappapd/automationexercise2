package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.ViewCart_Brand_Products;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase19_ViewCart_Brand_Products {
	private WebDriver driver;
	private ViewCart_Brand_Products viewCart_Brand_Products;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		viewCart_Brand_Products = new ViewCart_Brand_Products(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void POLOPRODUCTS() {
		viewCart_Brand_Products.PRODUCTS();
		viewCart_Brand_Products.poloPRODUCTS();

	}

	@Test(priority = 2, dependsOnMethods = "POLOPRODUCTS")
	public void VERIFYPOLOPRODUCTS() {
		viewCart_Brand_Products.verifypolobrandPageIsVisible();

	}

	@Test(priority = 3, dependsOnMethods = "VERIFYPOLOPRODUCTS")
	public void HMPRODUCTS() {
		viewCart_Brand_Products.hmPRODUCTS();

	}

	@Test(priority = 4, dependsOnMethods = "HMPRODUCTS")
	public void verifyHMPRODUCTS() {
		viewCart_Brand_Products.verifyhmbrandPageIsVisible();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
