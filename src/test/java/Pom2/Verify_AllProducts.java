package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verify_AllProducts {
	private WebDriver driver;
	WebDriverWait wait;

	public Verify_AllProducts(WebDriver driver) {
		this.driver = driver;
	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By products = By.xpath("//a[@href='/products']");
	private By productsverify = By.xpath("//a[contains(text(),'All Products')]");
	private By firstproduct = By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]");
	private By productname = By.xpath("//a[contains(text(),'Blue Top')]");
	private By productcategory = By.xpath("//a[contains(text(),'Category: Women > Tops')]");
	private By productrate = By.xpath("//a[contains(text(),'Rs. 500')]");
	private By productavailable = By.xpath("//a[contains(text(),' In Stock')]");
	private By productcondition = By.xpath("//a[contains(text(),' New')]");
	private By productbrand = By.xpath("//a[contains(text(),' Polo')]");

	public boolean isHomePageVisible() {
		return driver.findElement(homepage).isDisplayed();
		
	}

	public void productsclick() {
	
		WebElement clickproduct = driver.findElement(products);
		clickproduct.click();
		driver.navigate().refresh();
	
	}

	public boolean isproductsVisible() {
		
		return driver.findElement(productsverify).isDisplayed();
	}

	public void firstproductname() {
		WebElement namefirstproduct = driver.findElement(firstproduct);
		namefirstproduct.click();
	}

	public boolean isproductnameVisible() {
		return driver.findElement(productname).isDisplayed();
	}

	public boolean isproductscategoryVisible() {
		return driver.findElement(productcategory).isDisplayed();
	}

	public boolean isproductsrateVisible() {
		return driver.findElement(productrate).isDisplayed();
	}

	public boolean isproductsavailableVisible() {
		return driver.findElement(productavailable).isDisplayed();
	}

	public boolean isproductsconditionVisible() {
		return driver.findElement(productcondition).isDisplayed();
	}

	public boolean isproductsbrandVisible() {
		return driver.findElement(productbrand).isDisplayed();
	}

}
