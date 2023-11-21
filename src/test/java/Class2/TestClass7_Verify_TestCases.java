package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Verify_TestCases;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass7_Verify_TestCases {
	private WebDriver driver;
	private Verify_TestCases verify_TestCases;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		verify_TestCases = new Verify_TestCases(driver); // Corrected initialization
	}

	@Test
	public void testHomePageVisibility() {
		boolean isHomePageVisible = verify_TestCases.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test
	public void Testcase() {
		verify_TestCases.testcaseclick();
	}

	public void testtestcaseVisibility() {
		boolean istestcasePageVisible = verify_TestCases.istestcasePageVisible();
		Assert.assertTrue(istestcasePageVisible, "The homepage is not visible.");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
