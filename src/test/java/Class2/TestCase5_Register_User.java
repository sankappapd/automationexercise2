package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Register_User;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase5_Register_User {
	private WebDriver driver;
	private Register_User register_User;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		register_User = new Register_User(driver); // Corrected initialization
	}

	@Test
	public void testHomePageVisibility() {
		boolean isHomePageVisible = register_User.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "testHomePageVisibility")
	public void signup() {
		register_User.clicklogin();
	}

	@Test(dependsOnMethods = "signup")
	public void ISNEWUSERSIGNUPVisibility() {
		boolean NEWUSERSignupvisible = register_User.NEWUSERSignupvisible();
		Assert.assertTrue(NEWUSERSignupvisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "ISNEWUSERSIGNUPVisibility")
	public void details() {
		register_User.usernamelogin("sankappa1");
		register_User.emailid("sankupd333@gmail.com");
		register_User.signupbutton();
	}

	@Test(dependsOnMethods = "details")
	public void emailalreadyexist() {
		boolean erroraemailexist = register_User.erroraemailexist();
		Assert.assertTrue(erroraemailexist, "Email Address already exist!");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
