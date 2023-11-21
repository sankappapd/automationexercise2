package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register_User {
	private WebDriver driver;
	WebDriverWait wait;

	public Register_User(WebDriver driver) {
		this.driver = driver;
	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By login = By.xpath("//a[normalize-space()='Signup / Login']");
	private By signuptext = By.xpath("//*[contains(text(),'New User Signup!')]");
	private By username = By.xpath("//input[@placeholder='Name']");
	private By email = By.xpath("//input[@data-qa='signup-email']");
	private By signup = By.xpath("//button[normalize-space()='Signup']");
	private By alreadysignup = By.xpath("//*[contains(text(),'Email Address already exist!')]");

	public boolean isHomePageVisible() {
		return driver.findElement(homepage).isDisplayed();
	}

	public void clicklogin() {
		WebElement click = driver.findElement(login);
		click.click();
	}

	public boolean NEWUSERSignupvisible() {
		return driver.findElement(signuptext).isDisplayed();
	}

	public void usernamelogin(String usernames) {
		WebElement mail = driver.findElement(username);
		mail.sendKeys(usernames);
	}

	public void emailid(String mailid) {
		WebElement mail = driver.findElement(email);
		mail.sendKeys(mailid);
	}

	public void signupbutton() {
		WebElement signuphit = driver.findElement(signup);
		signuphit.click();
	}

	public boolean erroraemailexist() {
		return driver.findElement(alreadysignup).isDisplayed();
	}

}
