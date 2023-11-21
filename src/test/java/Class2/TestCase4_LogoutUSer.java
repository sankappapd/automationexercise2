package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Logout_User;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase4_LogoutUSer {
	private WebDriver driver;
	private Logout_User logout_User;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		logout_User = new Logout_User(driver); // Corrected initialization
	}

	@Test
	public void testHomePageVisibility() {
		boolean isHomePageVisible = logout_User.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "testHomePageVisibility")
	public void signup() {
		logout_User.clicklogin();
	}

	@Test(dependsOnMethods = "signup")
	public void testloginVisibility() {
		boolean isloginaccountVisible = logout_User.isloginaccountVisible();
		Assert.assertTrue(isloginaccountVisible, "login to account not visible.");
	}

	@Test(dependsOnMethods = "testloginVisibility")
	public void details() {
		logout_User.usernamelogin("sankupd335@gmail.com");
		logout_User.passwordenter("123456789");
		logout_User.clickloginbutton();
		logout_User.verifyuserlogIsVisible();
	}

	@Test(dependsOnMethods = "details")
	public void logout() {
		logout_User.clicklogoutbutton();
	}

	@Test(dependsOnMethods = "logout")
	public void loginpage() {
		logout_User.isloginVisible();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
