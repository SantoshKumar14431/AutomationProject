package HubSpotTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HubSpotBase.BasePage;
import HubSpotPages.LoginPage;
import HubSpotUtil.ElementUtil;
import junit.framework.Assert;

public class LoginPageTest {

	WebDriver driver;
	Properties prop;
	BasePage base;
	LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		base = new BasePage();
		prop = base.getProperties();
		String browser = prop.getProperty("browser");
		driver = base.initialization(browser);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage = new LoginPage(driver);

	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		String tile = loginPage.getPageTitle();
		Assert.assertEquals(tile, "HubSpot Login");
	}

	@Test(priority = 2)
	public void getLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
