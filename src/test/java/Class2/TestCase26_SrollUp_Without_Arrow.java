package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.SrollUp_Without_Arrow;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase26_SrollUp_Without_Arrow {
	private WebDriver driver;
	private SrollUp_Without_Arrow srollUp_Without_Arrow;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		srollUp_Without_Arrow = new SrollUp_Without_Arrow(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void Homepage() {
		srollUp_Without_Arrow.verifyHomePageIsVisible();

	}

	@Test(priority = 2)
	public void scrolljs() {
		srollUp_Without_Arrow.scroll();
	}

	@Test(priority = 3)
	public void subscriptionverify() {
		srollUp_Without_Arrow.verifysubscriptionIsVisible();

	}

	@Test(priority = 4)
	public void verifyhometext() {
		srollUp_Without_Arrow.clickup();
		srollUp_Without_Arrow.verifyengineertextIsVisible();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
