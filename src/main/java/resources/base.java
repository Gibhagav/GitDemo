package resources;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class base {

	public static WebDriver driver;
	public Properties p;

	public WebDriver initializeDriver() throws IOException {

		p = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\Girija_Interview\\EndtoEnd_POM_Project\\src\\main\\java\\resources\\data.properties");

		p.load(fis);
		String browserName = p.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"F:\\Girija_Interview\\Software\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"F:\\Girija_Interview\\Software\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");

			driver = new FirefoxDriver();

		}

		else if (browserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver",
					"F:\\Girija_Interview\\Software\\Selenium\\MicrosoftWebDriver.exe");

			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenshot(String result) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("F:\\Girija_Interview\\test\\"+result+"screenshot.png"));
		
		
	}

}