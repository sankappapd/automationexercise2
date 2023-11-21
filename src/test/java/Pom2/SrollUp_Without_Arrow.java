package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SrollUp_Without_Arrow {
	private WebDriver driver;
	WebDriverWait wait;

	public SrollUp_Without_Arrow(WebDriver driver) {
		this.driver = driver;

	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By subscription = By.xpath("//*[contains(text(),'Subscription')]");
	// private By scroolup = By.xpath("//i[@class='fa fa-angle-up']");
	private By verifytext = By.xpath("//*[contains(text(),'Full-Fledged practice website for Automation Engineers')]");

	public boolean isHomepagevisible() {
		return driver.findElement(homepage).isDisplayed();
	}

	public void verifyHomePageIsVisible() {
		Assert.assertTrue(isHomepagevisible(), "Home page is not visible.");
	}

	public void scroll() {
		// Locating element by link text and store in variable "Element"
		WebElement subscripttext = driver.findElement(subscription);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", subscripttext);
	}

	public boolean issubscriptionvisible() {
		return driver.findElement(subscription).isDisplayed();
	}

	public void verifysubscriptionIsVisible() {
		Assert.assertTrue(issubscriptionvisible(), "SUBSCRIPTION IS NOT VISIBLE");
	}

	public void clickup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");

	}

	public boolean isHomepagetextvisible() {
		return driver.findElement(verifytext).isDisplayed();
	}

	public void verifyengineertextIsVisible() {
		Assert.assertTrue(isHomepagetextvisible(),
				"Full-Fledged practice website for Automation Engineers not visible");
	}

}
