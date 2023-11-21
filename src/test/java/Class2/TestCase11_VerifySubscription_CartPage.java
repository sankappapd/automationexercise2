package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Verify_subscriptiob_Cartpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase11_VerifySubscription_CartPage {
	private WebDriver driver;
	private Verify_subscriptiob_Cartpage verify_subscriptiob_Cartpage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		verify_subscriptiob_Cartpage = new Verify_subscriptiob_Cartpage(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = verify_subscriptiob_Cartpage.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2)
	public void scrolljs() {
		verify_subscriptiob_Cartpage.cartbutton();
		verify_subscriptiob_Cartpage.scroll();
		verify_subscriptiob_Cartpage.emailid("sankupd33@gmail.com");
		verify_subscriptiob_Cartpage.arrowbutton();
	}
	@Test(priority = 3)
	public void testemailsuccessPageVisibility() {
		boolean issuccessfulemailVisible = verify_subscriptiob_Cartpage.issuccessfulemailVisible();
		Assert.assertTrue(issuccessfulemailVisible, "SUBSCRIPTION NOT SUCCESSFUL.");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
