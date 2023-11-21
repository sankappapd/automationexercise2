package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class View_Category_Products {
	private WebDriver driver;
	WebDriverWait wait;

	public View_Category_Products(WebDriver driver) {
		this.driver = driver;

	}

	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By category = By.xpath("//*[contains(text(),'Category')]");
	private By women = By.xpath("//a[normalize-space()='Women']");
	private By tops = By.xpath("//a[normalize-space()='Tops']");
	private By confirmwomentops = By.xpath("//*[contains(text(),'Women - Tops Products')]");
	private By men = By.xpath("//a[normalize-space()='Men']");
	private By menjeans = By.xpath("//a[normalize-space()='Jeans']");
	private By verifymenjeans = By.xpath("//*[contains(text(),'Men - Jeans Products')]");

	public boolean isHomepagevisible() {
		return driver.findElement(homepage).isDisplayed();
	}

	public void verifyHomePageIsVisible() {
		Assert.assertTrue(isHomepagevisible(), "Home page is not visible.");
	}

	public boolean iscategoriesvisible() {
		return driver.findElement(category).isDisplayed();
	}

	public void verifycategoriesIsVisible() {
		Assert.assertTrue(iscategoriesvisible(), "CATEGORIES NOT VISIBLE");
	}

	public void womencategory() {

		WebElement clickwomen = driver.findElement(women);
		clickwomen.click();

	}

	public void womentops() {
		WebElement clicktops = driver.findElement(tops);
		clicktops.click();
		// driver.navigate().refresh();
	}

	public boolean iswomencvategoryvisible() {
		return driver.findElement(confirmwomentops).isDisplayed();
	}

	public void verifyHwomentopsIsVisible() {
		Assert.assertTrue(iswomencvategoryvisible(), "WOMEN TOPS PRODUCT NOT VISIBLE");
	}

	public void mencategory() {
		WebElement clickmen = driver.findElement(men);
		clickmen.click();
	}

	public void menjeans() {
		WebElement clickjeans = driver.findElement(menjeans);
		clickjeans.click();
	}

	public boolean ismenjeansvategoryvisible() {
		return driver.findElement(verifymenjeans).isDisplayed();
	}

	public void verifyHmenjeansIsVisible() {
		Assert.assertTrue(ismenjeansvategoryvisible(), "MEN JEANS PRODUCT NOT VISIBLE");
	}

}
