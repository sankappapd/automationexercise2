package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Addreview_on_product {
	private WebDriver driver;
	WebDriverWait wait;

	public Addreview_on_product(WebDriver driver) {
		this.driver = driver;
	}

	private By product = By.xpath("//a[@href='/products']");
	private By allproducts = By.xpath("(//*[contains(text(),'All Products')])[2]");
	private By viewproduct = By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]");
	private By verifyrview = By.xpath("//*[contains(text(),'Write Your Review')]");
	private By namereview = By.xpath("//input[@id='name']");
	private By emailreview = By.xpath("//input[@id='email']");
	private By reviewsummary = By.xpath("//textarea[@id='review']");
	private By reviewsubmit = By.xpath("//button[@id='button-review']");
	private By reviewverify = By.xpath("//*[contains(text(),'Thank you for your review.')]");

	public void PRODUCTS() {
		driver.navigate().refresh();
		WebElement clickproduct = driver.findElement(product);
		clickproduct.click();

	}

	public boolean isallproductsvisible() {

		return driver.findElement(allproducts).isDisplayed();
	}

	public void verifyallproductsIsVisible() {
		Assert.assertTrue(isallproductsvisible(), "ALL PRODUCTS NOT VISIBLE");
	}

	public void viewPRODUCTS() {

		WebElement clickviewproduct = driver.findElement(viewproduct);
		clickviewproduct.click();

	}

	public boolean iswritereviewvisible() {

		return driver.findElement(verifyrview).isDisplayed();
	}

	public void verifiswritereviewvisibleIsVisible() {
		Assert.assertTrue(iswritereviewvisible(), "WRITE YPOUR REVIEW NOT VISIBLE");
	}

	public void nametoreview(String usernames) {
		WebElement name = driver.findElement(namereview);
		name.sendKeys(usernames);
	}

	public void emailtoreview(String emailtoreview) {
		WebElement emailrev = driver.findElement(emailreview);
		emailrev.sendKeys(emailtoreview);
	}

	public void descriptiontoreview(String description) {
		WebElement descript = driver.findElement(reviewsummary);
		descript.sendKeys(description);
	}

	public void submit() {

		WebElement clicksubmit = driver.findElement(reviewsubmit);
		clicksubmit.click();

	}

	public boolean isreviewsuccessvisible() {

		return driver.findElement(reviewverify).isDisplayed();
	}

	public void verifysuccessreviewIsVisible() {
		Assert.assertTrue(isreviewsuccessvisible(), "no review");
	}

}
