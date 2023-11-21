package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Loginwithvalidcredintials;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2_Loginwithvalidinput {
	private WebDriver driver;
	private Loginwithvalidcredintials loginwithvalidcredintials;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		loginwithvalidcredintials = new Loginwithvalidcredintials(driver); // Corrected initialization
	}

	@Test

	public void testHomePageVisibility() {
		boolean isHomePageVisible = loginwithvalidcredintials.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "testHomePageVisibility")
	public void signup() {
		loginwithvalidcredintials.clicklogin();
	}

	@Test(dependsOnMethods = "signup")
	public void testloginVisibility() {
		boolean isloginaccountVisible = loginwithvalidcredintials.isloginaccountVisible();
		Assert.assertTrue(isloginaccountVisible, "login to account not visible.");
	}

	@Test(dependsOnMethods = "testloginVisibility")
	public void details() {
		loginwithvalidcredintials.usernamelogin("sankupd335@gmail.com");
		loginwithvalidcredintials.passwordenter("123456789");
		loginwithvalidcredintials.clickloginbutton();
		loginwithvalidcredintials.verifyuserlogIsVisible();
		loginwithvalidcredintials.deletebutton();
		loginwithvalidcredintials.verifyuserdeleteIsVisible();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
