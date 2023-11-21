package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Recommended_items {
	private WebDriver driver;
	WebDriverWait wait;

	public Recommended_items(WebDriver driver) {
		this.driver = driver;
	}

	private By recommended = By.xpath("//*[contains(text(),'recommended items')]");
	private By verifyrecommended = By.xpath("//*[contains(text(),'recommended items')]");
	private By addtocart = By.xpath("//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]");
	private By viewcart = By.xpath("//u[normalize-space()='View Cart']");
	private By verifyviewcart = By.xpath("//*[contains(text(),'1')][@class=\"disabled\"]");

	public void scroll() {
		// Locating element by link text and store in variable "Element"
		WebElement subscripttext = driver.findElement(recommended);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", subscripttext);
	}

	public boolean isrecommendedVisible() {
		return driver.findElement(verifyrecommended).isDisplayed();
	}

	public void addtocarts() {

		WebElement add2cart = driver.findElement(addtocart);
		add2cart.click();

	}

	public void clickcart() {

		WebElement viewcartinto = driver.findElement(viewcart);
		viewcartinto.click();

	}

	public boolean isaddesitemsVisible() {
		return driver.findElement(verifyviewcart).isDisplayed();

	}

}
