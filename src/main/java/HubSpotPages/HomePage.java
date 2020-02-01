package HubSpotPages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HubSpotBase.BasePage;
import HubSpotUtil.ElementUtil;

public class HomePage extends BasePage {

	Properties prop;
	WebDriver driver;
	ElementUtil elementutil;

	By demo_tile = By.xpath("//*[text()='Restart demo']");
	By report_menu = By.xpath("(//*[@id='nav-primary-reports-branch'])[1]");
	By dashboard_submenu = By.xpath("(//*[@id='nav-secondary-dashboards'])[1]");
	By contact_menu = By.xpath("(//*[@id='nav-primary-contacts-branch'])[1]");
	By title_dashboard = By.xpath("//*[text()='Sales Dashboard']");
	By profile_menu = By.cssSelector("#account-menu");
	By profile_name = By.cssSelector(".user-info-name");
	By profil_email = By.cssSelector(".user-info-email");
	By contacts_menu = By.xpath("(//*[@id='nav-primary-contacts-branch'])[1]");
	By contacts = By.xpath("(//*[@id='nav-secondary-contacts'])[1]");
	By profile_img = By.xpath("//*[@class='nav-avatar']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);

	}

	public boolean verifyDemoTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(demo_tile));
		return driver.findElement(demo_tile).isDisplayed();
	}

	public void navigateToDashBoard() {
		elementutil.doClick(report_menu);
		elementutil.doClick(dashboard_submenu);
	}

	public void verifyDashboard() {
		elementutil.isElementDisplayed(title_dashboard);
	}

	public void verify_userprofile() {
		elementutil.doClick(profile_menu);
		String pro_em = elementutil.getText(profil_email);
		System.out.println(pro_em);
		String pro_name = elementutil.getText(profile_name);
		System.out.println(pro_name);
		elementutil.isElementDisplayed(profile_img);

	}

	public ContactPage getContact() {
		elementutil.doClick(contact_menu);
		elementutil.doClick(contacts);
		elementutil.getPageTitle();
		System.out.println(elementutil.getPageTitle());
		return new ContactPage(driver);
	}

}