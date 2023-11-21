package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verify_TestCases {
	private WebDriver driver;
	WebDriverWait wait;

	public Verify_TestCases(WebDriver driver) {
		this.driver = driver;
	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By testcase = By.xpath("//a[contains(text(),'Test Cases')]");
	private By testcaseverify = By.xpath("//a[contains(text(),'Test Cases')]");

	public boolean isHomePageVisible() {
		return driver.findElement(homepage).isDisplayed();
	}

	public void testcaseclick() {
		WebElement clicktest = driver.findElement(testcase);
		clicktest.click();
	}

	public boolean istestcasePageVisible() {
		return driver.findElement(testcaseverify).isDisplayed();
	}

}
