package Pom2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contact_User {
	private WebDriver driver;
	WebDriverWait wait;

	public Contact_User(WebDriver driver) {
		this.driver = driver;
	}

	// Define page elements with XPath locators
	private By homepage = By.xpath("//a[normalize-space()='Home']");
	private By contactus = By.xpath("//a[normalize-space()='Contact us']");
	private By verifyhelp = By.xpath("//*[contains(text(),'Get In Touch')]");
	private By username = By.xpath("//input[@placeholder='Name']");
	private By email = By.xpath("//input[@placeholder='Email']");
	private By subject = By.xpath("//input[@placeholder='Subject']");
	private By message = By.xpath("//textarea[@id='message']");
	private By upload = By.xpath("//input[@name='upload_file']");
	private By submit = By.xpath("//input[@name='submit']");
	private By success = By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]");
	private By home = By.xpath("//*[contains(text(),' Home')]");
	private By homepage2 = By.xpath("//a[normalize-space()='Home']");

	public boolean isHomePageVisible() {
		return driver.findElement(homepage).isDisplayed();
	}

	public void contactclick() {
		WebElement clickcontact = driver.findElement(contactus);
		clickcontact.click();
	}

	public boolean getintouch() {
		return driver.findElement(verifyhelp).isDisplayed();
	}

	public void usernamelogin(String usernames) {
		WebElement mail = driver.findElement(username);
		mail.sendKeys(usernames);
	}

	public void emailid(String mailid) {
		WebElement mail = driver.findElement(email);
		mail.sendKeys(mailid);
	}

	public void subjectbmessage(String submessage) {
		WebElement sub = driver.findElement(subject);
		sub.sendKeys(submessage);
	}

	public void messageinfo(String info) {
		WebElement msg = driver.findElement(message);
		msg.sendKeys(info);
	}

	public void uploadfile(String file) {
		WebElement fileupload = driver.findElement(upload);
		fileupload.sendKeys(file);
	}

	public void submitbutton() {
		WebElement subbutton = driver.findElement(submit);
		subbutton.click();
		driver.switchTo().alert().accept();
	}

	public boolean successmessage() {
		return driver.findElement(success).isDisplayed();
	}

	public void homeclick() {
		WebElement homepage = driver.findElement(home);
		homepage.click();
	}

	public boolean isHomePage2Visible() {
		return driver.findElement(homepage2).isDisplayed();
	}

}
