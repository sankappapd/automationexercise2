package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Download_Invoice;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase24_Download_Invoice {
	private WebDriver driver;
	private Download_Invoice download_Invoice;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		download_Invoice = new Download_Invoice(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void Homepage() {
		download_Invoice.verifyHomePageIsVisible();

	}

	@Test(priority = 2)
	public void productselect() {
		download_Invoice.productsclick();
	}

	@Test(priority = 3, dependsOnMethods = "productselect")
	public void productaddtocart() {
		download_Invoice.addtocartitem();
		download_Invoice.viewcartclick();
		download_Invoice.checkout();
		download_Invoice.registerbutton();
	}

	@Test(priority = 4, dependsOnMethods = "productaddtocart")
	public void details1() {
		download_Invoice.usernamelogin("sankappa1");
		download_Invoice.emailid("sankupd53313837737@gmail.com");
		download_Invoice.signupbutton();
		download_Invoice.signupIsVisible();
	}

	@Test(priority = 5, dependsOnMethods = "details1")
	public void details() {
		download_Invoice.srcheck();
		download_Invoice.passwordenter("123456789");
		download_Invoice.selectdob();
		download_Invoice.selectmonth();
		download_Invoice.selectyear();
	}

	@Test(priority = 6, dependsOnMethods = "details")
	public void buttons() {
		download_Invoice.newsbutton();
		download_Invoice.offer();
	}

	@Test(priority = 7, dependsOnMethods = "buttons")
	public void address() {
		download_Invoice.fnameenter("sankappa");
		download_Invoice.lnameenter("pd");
		download_Invoice.companyenter("xxx");
		download_Invoice.address1enter("bannikodu");
		download_Invoice.address2enter("davangere");
		download_Invoice.countryselect();
		download_Invoice.stateselect("karnataka");
		download_Invoice.cityselect("harihar");
		download_Invoice.zipselect("577516");
		download_Invoice.mobile("7760022359");
		download_Invoice.createbutton();
		download_Invoice.verifyacccreatedIsVisible();
		download_Invoice.continuebutton();
		download_Invoice.verifyuserlogIsVisible();
	}

	@Test(priority = 8, dependsOnMethods = "address")
	public void checkoutitems() {
		download_Invoice.cartclick();
		download_Invoice.proceedcheckoutclick();
	}

	@Test(priority = 9, dependsOnMethods = "checkoutitems")
	public void verifysamederliveryaddress() {

		download_Invoice.verifysamedeliveryVisible();

	}

	@Test(priority = 10, dependsOnMethods = "verifysamederliveryaddress")
	public void verifysamebillingaddress() {
		download_Invoice.verifysamebillingVisible();
	}

	@Test(priority = 11, dependsOnMethods = "verifysamebillingaddress")
	public void carddata() {
		download_Invoice.cartclick();
		download_Invoice.proceedcheckoutclick();
		download_Invoice.reviewdata("delivery as soon as possible");
		download_Invoice.orderplace();

		download_Invoice.cardnamedata("sankappa");
		download_Invoice.cardnumberdata("7760022359");
		download_Invoice.cvvdata("333");
		download_Invoice.expiraydate("2");
		download_Invoice.yeardate("2026");
		download_Invoice.paybutton();

	}

	@Test(priority = 12, dependsOnMethods = "carddata")
	public void orderconfirmvisible() {
		boolean orderconfirms = download_Invoice.orderconfirms();
		Assert.assertTrue(orderconfirms, "ORDER IS NOT PLACED");

	}

	@Test(priority = 13, dependsOnMethods = "orderconfirmvisible")
	public void invoicedown() {

		download_Invoice.downloadinvoice();
		download_Invoice.continuehomebutton();

	}

	@Test(priority = 14, dependsOnMethods = "invoicedown")
	public void verifylastdetails() {
		download_Invoice.deletebutton();
		download_Invoice.verifyuserdeleteIsVisible();
		download_Invoice.continue2homebutton();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
