package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By email = By.cssSelector("#user_email");
	By password = By.cssSelector("[type='password']");
	By submit = By.cssSelector("[type='submit']");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getEmail() throws InterruptedException {

		return driver.findElement(email);
	}

	public WebElement getPassword() {

		return driver.findElement(password);
	}

	public WebElement getSubmitBtn() {

		return driver.findElement(submit);

	}

}