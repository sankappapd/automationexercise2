package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search_Products {
	private WebDriver driver;
	WebDriverWait wait;

	public Search_Products(WebDriver driver) {
		this.driver = driver;
	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By products = By.xpath("//a[@href='/products']");
	private By productsverify = By.xpath("//h2[contains(text(),'All Products')]");
	private By search = By.xpath("//input[@id='search_product']");
	private By searchbuttonss = By.xpath("//i[@class='fa fa-search']");
	private By searchedproducts = By.xpath("//h2[contains(text(),'Searched Products')]");

	public boolean isHomePageVisible() {
		return driver.findElement(homepage).isDisplayed();
	}

	public void productsclick() {

		WebElement clickproduct = driver.findElement(products);
		clickproduct.click();
		driver.navigate().refresh();
		WebElement clickproduct1 = driver.findElement(products);
		clickproduct1.click();
	}

	public boolean isproductsVisible() {
		return driver.findElement(productsverify).isDisplayed();
	}

	public void Searchitem(String item) {
		WebElement searchbutton = driver.findElement(search);
		searchbutton.sendKeys(item);
	}

	public void searchclick() {
		WebElement searchproduct = driver.findElement(searchbuttonss);
		searchproduct.click();

	}

	public boolean issearchedproductsVisible() {
		return driver.findElement(searchedproducts).isDisplayed();
	}

}
