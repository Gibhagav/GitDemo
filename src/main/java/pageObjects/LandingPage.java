package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By featuredCourses = By.xpath("//h2[contains(text(),'Featured Courses')]");
//	By navBar= By.cssSelector(".nav navbar-nav navbar-right");
	
	By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	public LandingPage (WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement getLogin() throws InterruptedException {
		
		return driver.findElement(signin);
	}
	
	
	public WebElement getFeaturedCourses() throws InterruptedException {
		
		return driver.findElement(featuredCourses);
	}
	
	public WebElement getNavBar() {
		
		return driver.findElement(navBar);
	}

}
