package HubSpotPages;

import java.util.Properties;


/**
 * @author Santosh Kumar
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import HubSpotBase.BasePage;
import HubSpotUtil.ElementUtil;

public class LoginPage extends BasePage {

	WebDriver driver;
	Properties prop;
	BasePage base;
	ElementUtil elementutil;

	By uname = By.cssSelector("#username");
	By pwd = By.cssSelector("#password");
	By log_btn = By.cssSelector("#loginBtn");

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	    elementutil = new ElementUtil(driver);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the Login Page is " + title);
		return title;
	}
	
	
	public HomePage doLogin(String username, String password) {
		elementutil.doClick(uname);
		elementutil.doSendKeys(username, uname);
		elementutil.doClick(pwd);
		elementutil.doSendKeys(password, pwd);
		elementutil.doClick(log_btn);
		return new HomePage(driver);
		
	}
	
	
	

}
