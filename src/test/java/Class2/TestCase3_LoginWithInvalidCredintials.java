package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Login_WithValid_InvalidCredintials;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3_LoginWithInvalidCredintials {
	private WebDriver driver;
	private Login_WithValid_InvalidCredintials login_WithValid_InvalidCredintialsario3;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		login_WithValid_InvalidCredintialsario3 = new Login_WithValid_InvalidCredintials(driver); // Corrected initialization
	}

	@Test
	public void testHomePageVisibility() {
		boolean isHomePageVisible = login_WithValid_InvalidCredintialsario3.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "testHomePageVisibility")
	public void signup() {
		login_WithValid_InvalidCredintialsario3.clicklogin();
	}

	@Test(dependsOnMethods = "signup")
	public void testloginVisibility() {
		boolean isloginaccountVisible = login_WithValid_InvalidCredintialsario3.isloginaccountVisible();
		Assert.assertTrue(isloginaccountVisible, "login to account not visible.");
	}

	@Test(dependsOnMethods = "testloginVisibility")
	public void details() {
		login_WithValid_InvalidCredintialsario3.usernamelogin("sankupd335@gmail.com");
		login_WithValid_InvalidCredintialsario3.passwordenter("123456789");
		login_WithValid_InvalidCredintialsario3.clickloginbutton();

	}

	@Test(dependsOnMethods = "testloginVisibility")
	public void emailorpasswordincorrect() {
		boolean emailerror = login_WithValid_InvalidCredintialsario3.emailerror();
		Assert.assertTrue(emailerror, "login successful");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
