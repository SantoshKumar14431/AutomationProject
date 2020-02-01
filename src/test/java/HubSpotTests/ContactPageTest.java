package HubSpotTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtils.ExcelReaderClass;
import HubSpotBase.BasePage;
import HubSpotPages.ContactPage;
import HubSpotPages.HomePage;
import HubSpotPages.LoginPage;

public class ContactPageTest {

	WebDriver driver;
	BasePage base;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	ExcelReaderClass excelreader;

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
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.getContact();

	}

	@DataProvider
	public Object[][] getContactTestData() {
		Object[][] data = excelreader.getTestData("contacts");
		return data;
	}

	@Test(priority = 1, dataProvider = "getContactTestData")
	public void createContact(String email, String firstname, String lastname, String jobtitle)
			throws InterruptedException {
		contactPage.createContact(email, firstname, lastname, jobtitle);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
