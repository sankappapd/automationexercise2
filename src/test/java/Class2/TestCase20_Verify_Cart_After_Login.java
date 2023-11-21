package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Verify_Cart_After_Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase20_Verify_Cart_After_Login {
	private WebDriver driver;
	private Verify_Cart_After_Login verify_Cart_After_Login;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		verify_Cart_After_Login = new Verify_Cart_After_Login(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void PRODUCTSbutton() {
		verify_Cart_After_Login.PRODUCTS();
	}

	@Test(priority = 2, dependsOnMethods = "PRODUCTSbutton")
	public void VERIFYPOLOPRODUCTS() {
		verify_Cart_After_Login.verifyallproductsIsVisible();

	}

	@Test(priority = 3, dependsOnMethods = "VERIFYPOLOPRODUCTS")
	public void productsinput() {
		verify_Cart_After_Login.searchitem("jeans");
		verify_Cart_After_Login.PRODUCTSsearch();

	}

	@Test(priority = 4, dependsOnMethods = "productsinput")
	public void productssearchverify() {
		verify_Cart_After_Login.verifsearchedproductsIsVisible();

	}

	@Test(priority = 4, dependsOnMethods = "productssearchverify")
	public void Addingitemstocart() {
		verify_Cart_After_Login.additems1tocart();
		verify_Cart_After_Login.continue1();
		verify_Cart_After_Login.additems2tocart();
		verify_Cart_After_Login.continue2();
		verify_Cart_After_Login.additems3tocart();
		verify_Cart_After_Login.viewcart();

	}

	@Test(priority = 5, dependsOnMethods = "Addingitemstocart")
	public void logindetails() {
		verify_Cart_After_Login.clicklogin();
		verify_Cart_After_Login.usernamelogin("sankupd33@gmail.com");
		verify_Cart_After_Login.passwordenter("123456789");
		verify_Cart_After_Login.clickloginbutton();
		verify_Cart_After_Login.lastcart();
	}

	@Test(priority = 6, dependsOnMethods = "logindetails")
	public void verifyallitemsincart() {
		verify_Cart_After_Login.verifyallitemsIsVisible();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
