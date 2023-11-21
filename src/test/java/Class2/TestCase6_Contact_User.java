package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Contact_User;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase6_Contact_User {
	private WebDriver driver;
	private Contact_User contact_User;
	String path = ("C:\\Users\\SANKAPPA-PC\\eclipse-workspace\\selenium\\Excelrproject1\\src\\test\\java\\Class2\\mysql-init.txt.txt");

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		contact_User = new Contact_User(driver); // Corrected initialization
	}

	@Test
	public void testHomePageVisibility() {
		boolean isHomePageVisible = contact_User.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "testHomePageVisibility")
	public void contactushelp() {
		contact_User.contactclick();
	}

	@Test(dependsOnMethods = "contactushelp")
	public void getintouchvisiblity() {
		boolean getintouch = contact_User.getintouch();
		Assert.assertTrue(getintouch, "Get In Touch not visible");
	}

	@Test(dependsOnMethods = "getintouchvisiblity")
	public void detailsinfo() {
		contact_User.usernamelogin("sankappa");
		contact_User.emailid("sankupd33@gmail.com");
		contact_User.subjectbmessage("regarding error message");
		contact_User.messageinfo("please solve this error asap");
		contact_User.uploadfile(path);
		contact_User.submitbutton();
	}

	@Test(dependsOnMethods = "detailsinfo")
	public void successmessageVisibility() {
		boolean successmessage = contact_User.successmessage();
		Assert.assertTrue(successmessage, "NOT SUCCESS.");
		contact_User.homeclick();
	}

	public void testHomePage2Visibility() {
		boolean isHomePage2Visible = contact_User.isHomePage2Visible();
		Assert.assertTrue(isHomePage2Visible, "The homepage is not visible.");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
