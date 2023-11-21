package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Register_BeforeCheckOut {
	private WebDriver driver;
	WebDriverWait wait;

	public Register_BeforeCheckOut(WebDriver driver) {
		this.driver = driver;
	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By login = By.xpath("//a[normalize-space()='Signup / Login']");
	private By signuptext = By.xpath("//*[contains(text(),'New User Signup!')]");
	private By username = By.xpath("//input[@placeholder='Name']");
	private By email = By.xpath("//input[@data-qa='signup-email']");
	private By signup = By.xpath("//button[normalize-space()='Signup']");
	private By verifyacc = By.xpath("//*[contains(text(),'Enter Account Information')]");
	private By check = By.xpath("//input[@value='Mr']");
	private By password = By.xpath("//input[@id='password']");
	private By dobday = By.xpath("//select[@id='days']");
	private By dobmonth = By.xpath("//select[@id='months']");
	private By dobyear = By.xpath("//select[@id='years']");
	private By newsletter = By.xpath("//input[@id='newsletter']");
	private By offerbutton = By.xpath("//input[@id='optin']");
	private By fname = By.xpath("//input[@id='first_name']");
	private By lname = By.xpath("//input[@id='last_name']");
	private By company = By.xpath("//input[@id='company']");
	private By address1 = By.xpath("//input[@id='address1']");
	private By address2 = By.xpath("//input[@id='address2']");
	private By country = By.xpath("//select[@id='country']");
	private By state = By.xpath("//input[@id='state']");
	private By city = By.xpath("//input[@id='city']");
	private By zipcode = By.xpath("//input[@id='zipcode']");
	private By mob = By.xpath("//input[@id='mobile_number']");
	private By create = By.xpath("//button[normalize-space()='Create Account']");
	private By acccreated = By.xpath("//*[contains(text(),'Account Created!')]");
	private By continueb = By.xpath("//A[@data-qa=\"continue-button\"]");
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

	public void emailid(String mailid) {
		WebElement mail = driver.findElement(email);
		mail.sendKeys(mailid);
	}

	public void signupbutton() {
		WebElement signuphit = driver.findElement(signup);
		signuphit.click();
	}

	public boolean Signupverify() {
		return driver.findElement(verifyacc).isDisplayed();
	}

	public void signupIsVisible() {
		Assert.assertTrue(Signupverify(), "Enter Account Information is not visible");
	}

	public void srcheck() {
		WebElement checkbox = driver.findElement(check);
		checkbox.click();
	}

	public void passwordenter(String pass) {
		WebElement passbutton = driver.findElement(password);
		passbutton.sendKeys(pass);
	}

	public void selectdob() {
		WebElement day = driver.findElement(dobday);

		Select select = new Select(day);
		select.selectByIndex(12);
	}

	public void selectmonth() {
		WebElement month = driver.findElement(dobmonth);

		Select select = new Select(month);
		select.selectByIndex(4);
	}

	public void selectyear() {
		WebElement year = driver.findElement(dobyear);

		Select select = new Select(year);
		select.selectByValue("1994");
	}

	public void newsbutton() {
		WebElement news = driver.findElement(newsletter);
		news.click();
	}

	public void offer() {
		WebElement offerbuttonelement = driver.findElement(offerbutton);
		offerbuttonelement.click();
	}

	public void fnameenter(String names) {
		WebElement fnamebutton = driver.findElement(fname);
		fnamebutton.sendKeys(names);
	}

	public void lnameenter(String last) {
		WebElement lnamebutton = driver.findElement(lname);
		lnamebutton.sendKeys(last);
	}

	public void companyenter(String companynam) {
		WebElement companybutton = driver.findElement(company);
		companybutton.sendKeys(companynam);
	}

	public void address1enter(String add1) {
		WebElement addressbutton = driver.findElement(address1);
		addressbutton.sendKeys(add1);
	}

	public void address2enter(String add2) {
		WebElement address2button = driver.findElement(address2);
		address2button.sendKeys(add2);
	}

	public void countryselect() {
		WebElement count = driver.findElement(country);

		Select select = new Select(count);
		select.selectByVisibleText("India");
		;
	}

	public void stateselect(String states) {
		WebElement statebutton = driver.findElement(state);
		statebutton.sendKeys(states);
	}

	public void cityselect(String cities) {
		WebElement citybutton = driver.findElement(city);
		citybutton.sendKeys(cities);
	}

	public void zipselect(String zips) {
		WebElement zipbutton = driver.findElement(zipcode);
		zipbutton.sendKeys(zips);
	}

	public void mobile(String number) {
		WebElement mobilebutton = driver.findElement(mob);
		mobilebutton.sendKeys(number);
	}

	public void createbutton() {
		WebElement createelement = driver.findElement(create);
		createelement.click();
	}

	public boolean isacccreatedvisible() {
		return driver.findElement(acccreated).isDisplayed();
	}

	public void verifyacccreatedIsVisible() {
		Assert.assertTrue(isacccreatedvisible(), "ACCOUNT NOT CREATED.");

	}

	public void continuebutton() {
		driver.navigate().refresh();
		WebElement continueelement = driver.findElement(continueb);
		continueelement.click();
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
