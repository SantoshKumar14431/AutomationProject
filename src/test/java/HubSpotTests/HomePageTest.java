package HubSpotTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HubSpotBase.BasePage;
import HubSpotPages.HomePage;
import HubSpotPages.LoginPage;

public class HomePageTest {
	
	
WebDriver driver;
BasePage base;
Properties prop;
LoginPage loginPage;
HomePage homePage;

	
	@BeforeMethod
	public void setup(){
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
	    homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	    
		
	}

	
	@Test(priority =1)
	public void verifyProfile() {
		homePage.verifyDemoTitle();
		homePage.navigateToDashBoard();
		homePage.verifyDashboard();
		homePage.verify_userprofile();
		homePage.getContact();
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
