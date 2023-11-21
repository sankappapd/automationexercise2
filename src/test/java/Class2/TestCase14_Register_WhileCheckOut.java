package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Register_WhileCheckOut;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase14_Register_WhileCheckOut {

	private WebDriver driver;
	private Register_WhileCheckOut register_WhileCheckOut;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		register_WhileCheckOut = new Register_WhileCheckOut(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = register_WhileCheckOut.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2)
	public void productselect() {
		register_WhileCheckOut.productsclick();
	}

	@Test(priority = 3, dependsOnMethods = "productselect")
	public void productaddtocart() {
		register_WhileCheckOut.addtocartitem();
		register_WhileCheckOut.viewcartclick();
		register_WhileCheckOut.checkout();
		register_WhileCheckOut.registerbutton();
	}

	@Test(priority = 4, dependsOnMethods = "productaddtocart")
	public void details1() {
		register_WhileCheckOut.usernamelogin("sankappa1");
		register_WhileCheckOut.emailid("sankupd533137737@gmail.com");
		register_WhileCheckOut.signupbutton();
		register_WhileCheckOut.signupIsVisible();
	}

	@Test(dependsOnMethods = "details1")
	public void details() {
		register_WhileCheckOut.srcheck();
		register_WhileCheckOut.passwordenter("123456789");
		register_WhileCheckOut.selectdob();
		register_WhileCheckOut.selectmonth();
		register_WhileCheckOut.selectyear();
	}

	@Test(dependsOnMethods = "details")
	public void buttons() {
		register_WhileCheckOut.newsbutton();
		register_WhileCheckOut.offer();
	}

	@Test(dependsOnMethods = "buttons")
	public void address() {
		register_WhileCheckOut.fnameenter("sankappa");
		register_WhileCheckOut.lnameenter("pd");
		register_WhileCheckOut.companyenter("xxx");
		register_WhileCheckOut.address1enter("bannikodu");
		register_WhileCheckOut.address2enter("davangere");
		register_WhileCheckOut.countryselect();
		register_WhileCheckOut.stateselect("karnataka");
		register_WhileCheckOut.cityselect("harihar");
		register_WhileCheckOut.zipselect("577516");
		register_WhileCheckOut.mobile("7760022359");
		register_WhileCheckOut.createbutton();
		register_WhileCheckOut.verifyacccreatedIsVisible();
		register_WhileCheckOut.continuebutton();
		register_WhileCheckOut.verifyuserlogIsVisible();
	}

	@Test(dependsOnMethods = "address")
	public void carddata() {
		register_WhileCheckOut.cartclick();
		register_WhileCheckOut.proceedcheckoutclick();
		register_WhileCheckOut.reviewdata("delivery as soon as possible");
		register_WhileCheckOut.orderplace();

		register_WhileCheckOut.cardnamedata("sankappa");
		register_WhileCheckOut.cardnumberdata("7760022359");
		register_WhileCheckOut.cvvdata("333");
		register_WhileCheckOut.expiraydate("2");
		register_WhileCheckOut.yeardate("2026");
		register_WhileCheckOut.paybutton();

	}

	@Test(dependsOnMethods = "carddata")
	public void orderconfirmvisible() {
		boolean orderconfirms = register_WhileCheckOut.orderconfirms();
		Assert.assertTrue(orderconfirms, "ORDER IS NOT PLACED");

	}

	@Test(dependsOnMethods = "orderconfirmvisible")
	public void verifylastdetails() {
		register_WhileCheckOut.deletebutton();
		register_WhileCheckOut.verifyuserdeleteIsVisible();
		register_WhileCheckOut.continuehomebutton();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}