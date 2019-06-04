package PageObjectModel;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePageTest extends base {
	
	public static Logger Log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();
		Log.info("Driver is initialized");
	
	}

	@Test(dataProvider = "getData")

	public void basePageNavigation(String Username, String Password, String text)
			throws IOException, InterruptedException {

		
		LandingPage ob = new LandingPage(driver);
		driver.get(p.getProperty("url"));
		
		Log.info("Navigated to home page");
		ob.getLogin().click();
		
        Thread.sleep(2000L);
        
		LoginPage ob1 = new LoginPage(driver);
		ob1.getEmail().sendKeys(Username);
		ob1.getPassword().sendKeys(Password);
		Log.info(text);

		ob1.getSubmitBtn().click();

	}

	@DataProvider

	public Object[][] getData() {

		// Row stands for how many different data types test should run
		// Col stands for number of values needed for each test

		Object[][] data = new Object[2][3];

		// 0th row

		data[0][0] = "nonrestricteduser@q.com";
		data[0][1] = "1323435";
		data[0][2] = "Non Restricted User";

		// 1st Row
        
		data[1][0] = "restricteduser@q.com";
		data[1][1] = "1323435";
		data[1][2] = "Restricted User";

		return data;
	}

	@AfterTest
	
	public void tearDown() {
		
		driver.close();
		driver=null;
	}

}
