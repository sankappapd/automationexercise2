package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ViewCart_Brand_Products {
	private WebDriver driver;
	WebDriverWait wait;

	public ViewCart_Brand_Products(WebDriver driver) {
		this.driver = driver;
	}

	private By product = By.xpath("//a[@href='/products']");
	private By poloproduct = By.xpath("//a[@href='/brand_products/Polo']");
	private By verifypolo = By.xpath("//*[contains(text(),'Brand - Polo Products')]");
	private By hmproduct = By.xpath("//a[@href='/brand_products/H&M']");
	private By verifyhm = By.xpath("//*[contains(text(),'Brand - H&M Products')]");

	public void PRODUCTS() {

		WebElement clickproduct = driver.findElement(product);
		clickproduct.click();

	}

	public void poloPRODUCTS() {
		driver.navigate().refresh();

		WebElement clickpoloproduct = driver.findElement(poloproduct);
		clickpoloproduct.click();

	}

	public boolean ispolobrandvisible() {
		return driver.findElement(verifypolo).isDisplayed();
	}

	public void verifypolobrandPageIsVisible() {
		Assert.assertTrue(ispolobrandvisible(), "POLO BRAND NOT VISIBLE");
	}

	public void hmPRODUCTS() {

		WebElement clickhmproduct = driver.findElement(hmproduct);
		clickhmproduct.click();

	}

	public boolean ishmbrandvisible() {
		return driver.findElement(verifyhm).isDisplayed();
	}

	public void verifyhmbrandPageIsVisible() {
		Assert.assertTrue(ishmbrandvisible(), "HM NOT VISIBLE");
	}

}
