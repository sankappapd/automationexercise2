package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginBefore_Checkout {
	private WebDriver driver;
	WebDriverWait wait;

	public LoginBefore_Checkout(WebDriver driver) {
		this.driver = driver;
	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By login = By.xpath("//a[normalize-space()='Signup / Login']");
	private By signuptext = By.xpath("//*[contains(text(),'New User Signup!')]");
	private By username = By.xpath("//input[@data-qa='login-email']");
	private By password = By.xpath("//input[@placeholder='Password']");
	private By loginbutton = By.xpath("//button[normalize-space()='Login']");
	private By verifyuser = By.xpath("//*[contains(text(),'Logged in as ')]");
	private By addtocart = By.xpath("(//a[@data-product-id=\"1\"][@class=\"btn btn-default add-to-cart\"])[1]");
	private By viewcart = By.xpath("//*[contains(text(),'View Cart')]");
	private By checkout = By.xpath("//*[contains(text(),'Proceed To Checkout')]");
	private By review = By.xpath("//textarea[@name='message']");
	private By placeorder = By.xpath("//a[@class='btn btn-default check_out']");
	private By cardname = By.xpath("//div//form//div//div//input[@name=\"name_on_card\"]");
	private By cardnumber = By.xpath("//input[@name='card_number']");
	private By cvv = By.xpath("//input[@placeholder='ex. 311']");
	private By expiry = By.xpath("//input[@placeholder='MM']");
	private By yearcard = By.xpath("//input[@placeholder='YYYY']");
	private By pay = By.xpath("//button[@id='submit']");
	private By confirmorder = By.xpath("//*[contains(text(),'Order Placed!')]");
	private By delete = By.xpath("//*[contains(text(),' Delete Account')]");
	private By deleteverify = By.xpath("//*[contains(text(),'Account Deleted!')]");
	private By continuehome = By.xpath("//a[@data-qa=\"continue-button\"]");

	// Define page actions
	public boolean isHomepagevisible() {
		return driver.findElement(homepage).isDisplayed();
	}

	public void verifyHomePageIsVisible() {
		Assert.assertTrue(isHomepagevisible(), "Home page is not visible.");
	}

	public void clicklogin() {
		WebElement click = driver.findElement(login);
		click.click();
	}

	public boolean Signupvisible() {
		return driver.findElement(signuptext).isDisplayed();
	}

	public void verifysignupIsVisible() {
		Assert.assertTrue(Signupvisible(), "SIGNUP IS NOT VISIBLE.");
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

	public void addtocartitem() {
		driver.navigate().refresh();
		WebElement clickadd = driver.findElement(addtocart);
		clickadd.click();
	}

	public void viewcartclick() {
		WebElement clickviewcart = driver.findElement(viewcart);
		clickviewcart.click();
	}

	public void checkout() {
		WebElement clickcheckout = driver.findElement(checkout);
		clickcheckout.click();

	}

	
	public void reviewdata(String quote) {
		WebElement reviewbutton = driver.findElement(review);
		reviewbutton.sendKeys(quote);
	}

	public void orderplace() {
		WebElement orderbutton = driver.findElement(placeorder);
		orderbutton.click();
	}

	public void cardnamedata(String bank) {
		WebElement nameofbutton = driver.findElement(cardname);
		nameofbutton.click();
		nameofbutton.sendKeys(bank);
	}

	public void cardnumberdata(String cardnum) {
		WebElement reviewbutton = driver.findElement(cardnumber);
		reviewbutton.sendKeys(cardnum);
	}

	public void cvvdata(String cvvdate) {
		WebElement reviewbutton = driver.findElement(cvv);
		reviewbutton.sendKeys(cvvdate);
	}

	public void expiraydate(String expirydate) {
		WebElement expirybutton = driver.findElement(expiry);
		expirybutton.sendKeys(expirydate);
	}

	public void yeardate(String yeardata) {
		WebElement yearbutton = driver.findElement(yearcard);
		yearbutton.sendKeys(yeardata);
	}

	public void paybutton() {
		WebElement pays = driver.findElement(pay);
		pays.click();
	}

	public boolean orderconfirms() {
		return driver.findElement(confirmorder).isDisplayed();
	}

	public void deletebutton() {
		WebElement deleteelement = driver.findElement(delete);
		deleteelement.click();
	}

	public boolean isuserdeletevisible() {
		return driver.findElement(deleteverify).isDisplayed();
	}

	public void verifyuserdeleteIsVisible() {
		Assert.assertTrue(isuserdeletevisible(), "Account not deleted.");
	}

	public void continuehomebutton() {
		WebElement homeelement = driver.findElement(continuehome);
		homeelement.click();
	}

}