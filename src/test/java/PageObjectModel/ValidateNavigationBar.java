package PageObjectModel;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavigationBar extends base {
	
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();
		Log.info("Driver is initialized");
		
		driver.get(p.getProperty("url"));
		Log.info("Navigated to Navigation Page");
	}

	@Test

	public void basePageNavigation() throws IOException, InterruptedException {

		LandingPage ob = new LandingPage(driver);

		Assert.assertTrue(ob.getNavBar().isDisplayed());
		Log.info("Navigattion bar is displayed");
	}

	@AfterTest

	public void tearDown() {

		driver.close();
		driver=null;
	}

}
