package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductsIn_Cart {
	private WebDriver driver;
	WebDriverWait wait;

	public AddProductsIn_Cart(WebDriver driver) {
		this.driver = driver;
	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By products = By.xpath("//a[@href='/products']");
	private By addtocart = By.xpath("(//a[@data-product-id=\"1\"][@class=\"btn btn-default add-to-cart\"])[1]");
	private By continueshopping = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	private By addtocart2 = By.xpath("(//*[contains(text(),'Add to cart')])[3]");
	private By viewcart = By.xpath("//*[contains(text(),'View Cart')]");
	private By product1nameverify = By.xpath("//*[contains(text(),'Blue Top')]");
	private By product1priceverify = By.xpath("//*[contains(text(),'Rs. 500')]");
	private By product1quantityverify = By.xpath("//*[contains(text(),'1')]");
	private By product1totalpriceverify = By.xpath("//*[contains(text(),'Rs. 500')]");
	private By product2nameverify = By.xpath("//*[contains(text(),'Men Tshirt')]");
	private By product2priceverify = By.xpath("//*[contains(text(),'Rs. 400')]");
	private By product2quantityverify = By.xpath("//*[contains(text(),'1')]");
	private By product2totalpriceverify = By.xpath("//*[contains(text(),'Rs. 400')]");

	public boolean isHomePageVisible() {
		return driver.findElement(homepage).isDisplayed();
	}

	public void productsclick() {
		driver.navigate().refresh();

		WebElement clickproduct = driver.findElement(products);
		clickproduct.click();
	}

	public void addtocartitem() {
		driver.navigate().refresh();
		WebElement clickadd = driver.findElement(addtocart);
		clickadd.click();
	}

	public void continuetoadd() {
		// driver.navigate().refresh();
		WebElement clickcontinue = driver.findElement(continueshopping);
		clickcontinue.click();
	}

	public void continuetoaddcart2() {
		driver.navigate().refresh();
		WebElement clickaddcart2 = driver.findElement(addtocart2);
		clickaddcart2.click();
	}

	public void viewcartclick() {
		WebElement clickviewcart = driver.findElement(viewcart);
		clickviewcart.click();
	}

	public boolean productsverify() {
		return driver.findElement(product1nameverify).isDisplayed();

	}

	public boolean products1rateverify() {
		return driver.findElement(product1priceverify).isDisplayed();
	}

	public boolean products1quantityverify() {
		return driver.findElement(product1quantityverify).isDisplayed();
	}

	public boolean products1totalpriceverify() {
		return driver.findElement(product1totalpriceverify).isDisplayed();
	}

	public boolean products2verify() {
		return driver.findElement(product2nameverify).isDisplayed();

	}

	public boolean products2rateverify() {
		return driver.findElement(product2priceverify).isDisplayed();
	}

	public boolean products2quantityverify() {
		return driver.findElement(product2quantityverify).isDisplayed();
	}

	public boolean products1tota2priceverify() {
		return driver.findElement(product2totalpriceverify).isDisplayed();
	}

}
