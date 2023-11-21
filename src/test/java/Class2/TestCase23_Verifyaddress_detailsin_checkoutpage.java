package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Verifyaddress_detailsin_checkoutpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase23_Verifyaddress_detailsin_checkoutpage {
	private WebDriver driver;
	private Verifyaddress_detailsin_checkoutpage verifyaddress_detailsin_checkoutpage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		verifyaddress_detailsin_checkoutpage = new Verifyaddress_detailsin_checkoutpage(driver); // Corrected initialization
	}

	@Test
	public void Homepage() {
		verifyaddress_detailsin_checkoutpage.verifyHomePageIsVisible();

	}

	@Test
	public void signuptest() {
		verifyaddress_detailsin_checkoutpage.clicklogin();
		verifyaddress_detailsin_checkoutpage.verifysignupIsVisible();
		verifyaddress_detailsin_checkoutpage.usernamelogin("sankappa1");
		verifyaddress_detailsin_checkoutpage.emailid("sankupd439633@gmail.com");
		verifyaddress_detailsin_checkoutpage.signupbutton();
		verifyaddress_detailsin_checkoutpage.signupIsVisible();

	}

	@Test(dependsOnMethods = "signuptest")
	public void details() {
		verifyaddress_detailsin_checkoutpage.srcheck();
		verifyaddress_detailsin_checkoutpage.passwordenter("123456789");
		verifyaddress_detailsin_checkoutpage.selectdob();
		verifyaddress_detailsin_checkoutpage.selectmonth();
		verifyaddress_detailsin_checkoutpage.selectyear();
	}

	@Test(dependsOnMethods = "details")
	public void buttons() {
		verifyaddress_detailsin_checkoutpage.newsbutton();
		verifyaddress_detailsin_checkoutpage.offer();
	}

	@Test(dependsOnMethods = "buttons")
	public void address() {
		verifyaddress_detailsin_checkoutpage.fnameenter("sankappa");
		verifyaddress_detailsin_checkoutpage.lnameenter("pd");
		verifyaddress_detailsin_checkoutpage.companyenter("xxx");
		verifyaddress_detailsin_checkoutpage.address1enter("bannikodu");
		verifyaddress_detailsin_checkoutpage.address2enter("davangere");
		verifyaddress_detailsin_checkoutpage.countryselect();
		verifyaddress_detailsin_checkoutpage.stateselect("karnataka");
		verifyaddress_detailsin_checkoutpage.cityselect("harihar");
		verifyaddress_detailsin_checkoutpage.zipselect("577516");
		verifyaddress_detailsin_checkoutpage.mobile("7760022359");
		verifyaddress_detailsin_checkoutpage.createbutton();
		verifyaddress_detailsin_checkoutpage.verifyacccreatedIsVisible();
		verifyaddress_detailsin_checkoutpage.continuebutton();
		verifyaddress_detailsin_checkoutpage.verifyuserlogIsVisible();
	}

	@Test(dependsOnMethods = "address")
	public void productselect() {
		verifyaddress_detailsin_checkoutpage.productsclick();
	}

	@Test(dependsOnMethods = "productselect")
	public void productaddtocart() {
		verifyaddress_detailsin_checkoutpage.addtocartitem();
		verifyaddress_detailsin_checkoutpage.viewcartclick();
		verifyaddress_detailsin_checkoutpage.checkout();
	}

	@Test(dependsOnMethods = "productaddtocart")
	public void verifysamederliveryaddress() {

		verifyaddress_detailsin_checkoutpage.verifysamedeliveryVisible();

	}

	@Test(dependsOnMethods = "verifysamederliveryaddress")
	public void verifysamebillingaddress() {
		verifyaddress_detailsin_checkoutpage.verifysamebillingVisible();
	}

	@Test(dependsOnMethods = "verifysamebillingaddress")
	public void verifylastdetails() {
		verifyaddress_detailsin_checkoutpage.deletebutton();
		verifyaddress_detailsin_checkoutpage.verifyuserdeleteIsVisible();
		verifyaddress_detailsin_checkoutpage.continuehomebutton();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
