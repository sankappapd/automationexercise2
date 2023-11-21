package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Addreview_on_product;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase21_Addreview_on_product {
	private WebDriver driver;
	private Addreview_on_product addreview_on_product;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		addreview_on_product = new Addreview_on_product(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void PRODUCTSbutton() {
		addreview_on_product.PRODUCTS();
	}

	@Test(priority = 2, dependsOnMethods = "PRODUCTSbutton")
	public void VERIFYPOLOPRODUCTS() {
		addreview_on_product.verifyallproductsIsVisible();
		addreview_on_product.viewPRODUCTS();

	}

	@Test(priority = 3, dependsOnMethods = "VERIFYPOLOPRODUCTS")
	public void verifyreview() {
		addreview_on_product.verifiswritereviewvisibleIsVisible();
		addreview_on_product.nametoreview("sankappa");
		addreview_on_product.emailtoreview("sankupd33@gmail");
		addreview_on_product.descriptiontoreview("quality of the product is awesome");
		addreview_on_product.submit();
	}

	@Test(priority = 4, dependsOnMethods = "verifyreview")
	public void reviewsuccessmessage() {
		addreview_on_product.verifysuccessreviewIsVisible();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
