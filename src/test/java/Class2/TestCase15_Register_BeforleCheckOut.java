package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Register_BeforeCheckOut;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase15_Register_BeforleCheckOut {

	private WebDriver driver;
	private Register_BeforeCheckOut register_BeforeCheckOut;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		register_BeforeCheckOut = new Register_BeforeCheckOut(driver); // Corrected initialization
	}

	@Test
	public void Homepage() {
		register_BeforeCheckOut.verifyHomePageIsVisible();

	}

	@Test
	public void signuptest() {
		register_BeforeCheckOut.clicklogin();
		register_BeforeCheckOut.verifysignupIsVisible();
		register_BeforeCheckOut.usernamelogin("sankappa1");
		register_BeforeCheckOut.emailid("sankupd001@gmail.com");
		register_BeforeCheckOut.signupbutton();
		register_BeforeCheckOut.signupIsVisible();

	}

	@Test(dependsOnMethods = "signuptest")
	public void details() {
		register_BeforeCheckOut.srcheck();
		register_BeforeCheckOut.passwordenter("123456789");
		register_BeforeCheckOut.selectdob();
		register_BeforeCheckOut.selectmonth();
		register_BeforeCheckOut.selectyear();
	}

	@Test(dependsOnMethods = "details")
	public void buttons() {
		register_BeforeCheckOut.newsbutton();
		register_BeforeCheckOut.offer();
	}

	@Test(dependsOnMethods = "buttons")
	public void address() {
		register_BeforeCheckOut.fnameenter("sankappa");
		register_BeforeCheckOut.lnameenter("pd");
		register_BeforeCheckOut.companyenter("xxx");
		register_BeforeCheckOut.address1enter("bannikodu");
		register_BeforeCheckOut.address2enter("davangere");
		register_BeforeCheckOut.countryselect();
		register_BeforeCheckOut.stateselect("karnataka");
		register_BeforeCheckOut.cityselect("harihar");
		register_BeforeCheckOut.zipselect("577516");
		register_BeforeCheckOut.mobile("7760022359");
		register_BeforeCheckOut.createbutton();
		register_BeforeCheckOut.verifyacccreatedIsVisible();
		register_BeforeCheckOut.continuebutton();
		register_BeforeCheckOut.verifyuserlogIsVisible();
	}

	@Test(dependsOnMethods = "address")
	public void productaddtocart() {
		register_BeforeCheckOut.addtocartitem();
		register_BeforeCheckOut.viewcartclick();
		register_BeforeCheckOut.checkout();
	}

	@Test(dependsOnMethods = "productaddtocart")
	public void carddata() {
		register_BeforeCheckOut.reviewdata("delivery as soon as possible");
		register_BeforeCheckOut.orderplace();

		register_BeforeCheckOut.cardnamedata("sankappa");
		register_BeforeCheckOut.cardnumberdata("7760022359");
		register_BeforeCheckOut.cvvdata("333");
		register_BeforeCheckOut.expiraydate("2");
		register_BeforeCheckOut.yeardate("2026");
		register_BeforeCheckOut.paybutton();

	}

	@Test(dependsOnMethods = "carddata")
	public void orderconfirmvisible() {
		boolean orderconfirms = register_BeforeCheckOut.orderconfirms();
		Assert.assertTrue(orderconfirms, "The homepage is not visible.");

	}

	@Test(dependsOnMethods = "orderconfirmvisible")
	public void verifylastdetails() {
		register_BeforeCheckOut.deletebutton();
		register_BeforeCheckOut.verifyuserdeleteIsVisible();
		register_BeforeCheckOut.continuehomebutton();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
