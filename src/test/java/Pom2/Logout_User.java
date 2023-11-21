package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Logout_User {
	private WebDriver driver;
	WebDriverWait wait;

	public Logout_User(WebDriver driver) {
		this.driver = driver;
	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By login = By.xpath("//a[normalize-space()='Signup / Login']");
	private By verifylogin = By.xpath("//*[contains(text(),'Login to your account')]");
	private By username = By.xpath("//input[@data-qa='login-email']");
	private By password = By.xpath("//input[@placeholder='Password']");
	private By loginbutton = By.xpath("//button[normalize-space()='Login']");
	private By verifyuser = By.xpath("//*[contains(text(),'Logged in as ')]");
	private By logut = By.xpath("//a[normalize-space()='Logout']");
	private By backlogin = By.xpath("//*[contains(text(),'Login to your account')]");

	public boolean isHomePageVisible() {
		return driver.findElement(homepage).isDisplayed();
	}

	public void clicklogin() {
		WebElement click = driver.findElement(login);
		click.click();
	}

	public boolean isloginaccountVisible() {
		return driver.findElement(verifylogin).isDisplayed();
	}

	public void usernamelogin(String usernames) {
		WebElement mail = driver.findElement(username);
		mail.sendKeys(usernames);
	}

	public void passwordenter(String pass) {
		WebElement passbutton = driver.findElement(password);
		passbutton.sendKeys(pass);
	}

	public void clickloginbutton() {
		WebElement clicklogins = driver.findElement(loginbutton);
		clicklogins.click();
	}

	public boolean isuserloginvisible() {
		return driver.findElement(verifyuser).isDisplayed();
	}

	public void verifyuserlogIsVisible() {
		Assert.assertTrue(isuserloginvisible(), "User log not found.");
	}

	public void clicklogoutbutton() {
		WebElement clicklogut = driver.findElement(logut);
		clicklogut.click();
	}

	public boolean isloginVisible() {
		return driver.findElement(backlogin).isDisplayed();
	}

}
