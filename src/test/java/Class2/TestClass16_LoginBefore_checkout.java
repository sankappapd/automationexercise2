package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.LoginBefore_Checkout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass16_LoginBefore_checkout {
	private WebDriver driver;
	private LoginBefore_Checkout loginBefore_Checkout;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		loginBefore_Checkout = new LoginBefore_Checkout(driver); // Corrected initialization
	}

	@Test
	public void Homepage() {
		loginBefore_Checkout.verifyHomePageIsVisible();

	}

	@Test
	public void signuptest() {
		loginBefore_Checkout.clicklogin();
		loginBefore_Checkout.verifysignupIsVisible();
	}

	@Test(dependsOnMethods = "signuptest")
	public void details() {
		loginBefore_Checkout.usernamelogin("sankupd7875@gmail.com");
		loginBefore_Checkout.passwordenter("12345678");
		loginBefore_Checkout.clickloginbutton();
		loginBefore_Checkout.verifyuserlogIsVisible();

	}

	@Test(dependsOnMethods = "details")
	public void productaddtocart() {
		loginBefore_Checkout.addtocartitem();
		loginBefore_Checkout.viewcartclick();
		loginBefore_Checkout.checkout();
	}

	@Test(dependsOnMethods = "productaddtocart")
	public void carddata() {
		loginBefore_Checkout.reviewdata("delivery as soon as possible");
		loginBefore_Checkout.orderplace();

		loginBefore_Checkout.cardnamedata("sankappa");
		loginBefore_Checkout.cardnumberdata("7760022359");
		loginBefore_Checkout.cvvdata("333");
		loginBefore_Checkout.expiraydate("2");
		loginBefore_Checkout.yeardate("2026");
		loginBefore_Checkout.paybutton();

	}

	@Test(dependsOnMethods = "carddata")
	public void orderconfirmvisible() {
		boolean orderconfirms = loginBefore_Checkout.orderconfirms();
		Assert.assertTrue(orderconfirms, "The homepage is not visible.");

	}

	@Test(dependsOnMethods = "orderconfirmvisible")
	public void verifylastdetails() {
		loginBefore_Checkout.deletebutton();
		loginBefore_Checkout.verifyuserdeleteIsVisible();
		loginBefore_Checkout.continuehomebutton();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
