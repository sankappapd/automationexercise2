package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Verify_Cart_After_Login {
	private WebDriver driver;
	WebDriverWait wait;

	public Verify_Cart_After_Login(WebDriver driver) {
		this.driver = driver;
	}

	private By product = By.xpath("//a[@href='/products']");
	private By allproducts = By.xpath("(//*[contains(text(),'All Products')])[2]");
	private By searchproducts = By.xpath("//input[@id='search_product']");
	private By clicksearch = By.xpath("//button[@id='submit_search']");
	private By verifysearched = By.xpath("//*[contains(text(),'Searched Products')]");
	private By item1tocart = By.xpath("(//div//a[@class=\"btn btn-default add-to-cart\"])[1]");
	private By item1continue = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	private By item2tocart = By.xpath("(//div//a[@class=\"btn btn-default add-to-cart\"])[3]");
	private By item2continue = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	private By item3tocart = By.xpath("(//div//a[@class=\"btn btn-default add-to-cart\"])[5]");
	private By viewcart = By.xpath("(//a[@href=\"/view_cart\"])[2]");
	private By login = By.xpath("//a[normalize-space()='Signup / Login']");
	private By username = By.xpath("//input[@data-qa='login-email']");
	private By password = By.xpath("//input[@placeholder='Password']");
	private By loginbutton = By.xpath("//button[normalize-space()='Login']");
	private By maincart = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]");
	private By verifysitems = By.xpath("//*[contains(text(),'Soft Stretch Jeans')]");

	public void PRODUCTS() {

		WebElement clickproduct = driver.findElement(product);
		clickproduct.click();

	}

	public boolean isallproductsvisible() {

		return driver.findElement(allproducts).isDisplayed();
	}

	public void verifyallproductsIsVisible() {
		Assert.assertTrue(isallproductsvisible(), "ALL PRODUCTS NOT VISIBLE");
	}

	public void searchitem(String product1) {
		driver.navigate().refresh();
		WebElement searchinput = driver.findElement(searchproducts);
		searchinput.sendKeys(product1);
	}

	public void PRODUCTSsearch() {

		WebElement clicksearch1 = driver.findElement(clicksearch);
		clicksearch1.click();

	}

	public boolean issearchedproductsvisible() {
		return driver.findElement(verifysearched).isDisplayed();
	}

	public void verifsearchedproductsIsVisible() {
		Assert.assertTrue(issearchedproductsvisible(), "ALL PRODUCTS NOT VISIBLE");
	}

	public void additems1tocart() {

		WebElement addtoitem1cart = driver.findElement(item1tocart);
		addtoitem1cart.click();

	}

	public void continue1() {

		WebElement continueitem1cart = driver.findElement(item1continue);
		continueitem1cart.click();

	}

	public void additems2tocart() {

		WebElement addtoitem2cart = driver.findElement(item2tocart);
		addtoitem2cart.click();

	}

	public void continue2() {

		WebElement continueitem2cart = driver.findElement(item2continue);
		continueitem2cart.click();

	}

	public void additems3tocart() {

		WebElement addtoitem3cart = driver.findElement(item3tocart);
		addtoitem3cart.click();

	}

	public void viewcart() {

		WebElement viewcartitems = driver.findElement(viewcart);
		viewcartitems.click();

	}

	public void clicklogin() {
		WebElement click = driver.findElement(login);
		click.click();
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

	public void lastcart() {
		WebElement clickmaincart = driver.findElement(maincart);
		clickmaincart.click();
	}

	public boolean isitemsvisibleincart() {

		return driver.findElement(verifysitems).isDisplayed();
	}

	public void verifyallitemsIsVisible() {
		Assert.assertTrue(isitemsvisibleincart(), "ALL PRODUCTS NOT VISIBLE");
	}

}
