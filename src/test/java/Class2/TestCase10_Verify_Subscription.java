package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Verify_Subscription;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase10_Verify_Subscription {
	private WebDriver driver;
	private Verify_Subscription verify_Subscription;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		verify_Subscription = new Verify_Subscription(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = verify_Subscription.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2)
	public void scrolljs() {
		verify_Subscription.scroll();
		verify_Subscription.emailid("sankupd33@gmail.com");
		verify_Subscription.arrowbutton();
	}

	@Test(priority = 3)
	public void testemailsuccessPageVisibility() {
		boolean issuccessfulemailVisible = verify_Subscription.issuccessfulemailVisible();
		Assert.assertTrue(issuccessfulemailVisible, "SUBSCRIPTION NOT SUCCESSFUL.");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
