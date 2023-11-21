package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verify_ProductQuantity {
	private WebDriver driver;
	WebDriverWait wait;

	public Verify_ProductQuantity(WebDriver driver) {
		this.driver = driver;
	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By products1 = By
			.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]");
	private By product1nameverify = By.xpath("//*[contains(text(),'Blue Top')]");
	private By quantityup = By.xpath("//input[@id='quantity']");
	private By add2cart = By.xpath("//button[@type='button']");
	private By viewcart = By.xpath("//u[normalize-space()='View Cart']");
	private By verifyitem = By.xpath("//*[contains(text(),'Blue Top')]");
	private By quantityvisible = By.xpath("//*[contains(text(),'4')]");

	public boolean isHomePageVisible() {
		return driver.findElement(homepage).isDisplayed();
	}

	public void productsclick() {
		// driver.navigate().refresh();

		WebElement clickproduct = driver.findElement(products1);
		clickproduct.click();
		driver.navigate().refresh();
	}

	public boolean isviewproductVisible() {
		return driver.findElement(product1nameverify).isDisplayed();
	}

	public void clickIncreaseButton(String quant) {
		WebElement quantities = driver.findElement(quantityup);
		quantities.click();
		quantities.clear();
		quantities.sendKeys(quant);
	}

	public void addcartbutton() {
		driver.findElement(add2cart).click();
	}

	public void viewcartitem() {
		driver.findElement(viewcart).click();

	}

	public boolean isitemsVisible() {
		return driver.findElement(verifyitem).isDisplayed();
	}

	public boolean isitemsquantityVisible() {
		return driver.findElement(quantityvisible).isDisplayed();
	}

}
