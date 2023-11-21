package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.SrollUp_Using_Arrow;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase25_SrollUp_Using_Arrow {
	private WebDriver driver;
    private SrollUp_Using_Arrow srollUp_Using_Arrow;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

        driver.get("https://automationexercise.com/"); // Replace with your login page URL
        srollUp_Using_Arrow = new SrollUp_Using_Arrow(driver); // Corrected initialization
    }

    @Test(priority=1)
    public void Homepage() {
        srollUp_Using_Arrow.verifyHomePageIsVisible();
        
       }

@Test(priority=2)
public void scrolljs() {
	srollUp_Using_Arrow.scroll();
	srollUp_Using_Arrow.clickup();
}
@Test(priority=3)
public void verifyhometext() {
	srollUp_Using_Arrow.verifyengineertextIsVisible();
}
	
	
@AfterTest
public void tearDown() {
    driver.quit();
    
}
	
	
	
	
	
	
	
}
