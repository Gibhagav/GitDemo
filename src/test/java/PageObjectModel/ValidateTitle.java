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

public class ValidateTitle extends base {
	
	public static Logger Log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();
		Log.info("Driver is initialized");
		
		driver.get(p.getProperty("url"));
	}

	@Test

	public void basePageNavigation() throws IOException, InterruptedException {

		LandingPage ob = new LandingPage(driver);

		Assert.assertEquals(ob.getFeaturedCourses().getText(), "FEATURED COURSES123");
		Log.info("Successfully validated the text");
	}

	@AfterTest

	public void tearDown() {

		driver.close();
		driver=null;
	}

}
