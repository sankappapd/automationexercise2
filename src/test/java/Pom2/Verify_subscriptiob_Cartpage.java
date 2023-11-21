package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verify_subscriptiob_Cartpage {
	private WebDriver driver;
	WebDriverWait wait;

	public Verify_subscriptiob_Cartpage(WebDriver driver) {
		this.driver = driver;
	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By cart = By.xpath("//a[normalize-space()='Cart']");
	private By subscription = By.xpath("//*[contains(text(),'Subscription')]");
	private By emsilsubscription = By.xpath("//input[@id='susbscribe_email']");
	private By submit = By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
	private By subverify = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");

	public boolean isHomePageVisible() {
		return driver.findElement(homepage).isDisplayed();
	}

	public void cartbutton() {
		WebElement cartviewbutton = driver.findElement(cart);
		cartviewbutton.click();
	}

	public void scroll() {
		// Locating element by link text and store in variable "Element"
		WebElement subscripttext = driver.findElement(subscription);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", subscripttext);
	}

	public void emailid(String mailid) {
		WebElement mail = driver.findElement(emsilsubscription);
		mail.sendKeys(mailid);
	}

	public void arrowbutton() {
		WebElement arrowhit = driver.findElement(submit);
		arrowhit.click();
	}

	public boolean issuccessfulemailVisible() {
		return driver.findElement(subverify).isDisplayed();
	}

}
