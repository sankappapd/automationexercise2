package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.RegisterUser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1_RegisterUser {

    private WebDriver driver;
    private RegisterUser registerUser;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://automationexercise.com/"); // Replace with your login page URL
        registerUser = new RegisterUser(driver); // Corrected initialization
    }

    @Test
    public void Homepage() {
    	registerUser.verifyHomePageIsVisible();
        
       }
    @Test
    public void signuptest() {
    	registerUser.clicklogin();
    	registerUser.verifysignupIsVisible();
    	registerUser.usernamelogin("sankappa1");
        registerUser.emailid("sankupd335@gmail.com");
        registerUser.signupbutton();
        registerUser.signupIsVisible();
        
       }
    @Test(dependsOnMethods="signuptest")
    public void details() {
    	registerUser.srcheck();
    	registerUser.passwordenter("123456789");
    	registerUser.selectdob();
    	registerUser.selectmonth();
    	registerUser.selectyear();
    }
    @Test(dependsOnMethods="details")
    public void buttons() {
    	registerUser.newsbutton();
    	registerUser.offer();
    }
    @Test(dependsOnMethods="buttons")
    public void address() {
    	registerUser.fnameenter("sankappa");
    	registerUser.lnameenter("pd");
    	registerUser.companyenter("xxx");
    	registerUser.address1enter("bannikodu");
    	registerUser.address2enter("davangere");
    	registerUser.countryselect();
    	registerUser.stateselect("karnataka");
    	registerUser.cityselect("harihar");
    	registerUser.zipselect("577516");
    	registerUser.mobile("7760022359");
    	registerUser.createbutton();
    	registerUser.verifyacccreatedIsVisible();
    	registerUser.continuebutton();
    	registerUser.verifyuserlogIsVisible();
    	registerUser.deletebutton();
    	registerUser.verifyuserdeleteIsVisible();
    	registerUser.lastcontinuebutton();
    }
  
    @AfterTest
    public void tearDown() {
        driver.quit();
        
    }
    
}
