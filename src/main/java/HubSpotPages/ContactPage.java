package HubSpotPages;

import org.openqa.selenium.By;





/**
 * @author Santosh Kumar
 */
import org.openqa.selenium.WebDriver;
import HubSpotBase.BasePage;
import HubSpotUtil.ElementUtil;

public class ContactPage extends BasePage {

	WebDriver driver;
	ElementUtil elementutil;

	By cc_btn = By.xpath("//*[text()='Create contact']");
	By email_txt = By.xpath("//*[@data-field='email']");
	By first_name_txt = By.xpath("//*[@data-field='firstname']");
	By last_name_txt = By.xpath("//*[@data-field='lastname']");
	By job_title_txt = By.xpath("//*[@data-field='jobtitle']");
	By creat_contact_btn = By.xpath("//button[@data-selenium-test='base-dialog-confirm-btn']");

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
	}

	public void createContact(String email, String firstname, String lastname, String jobtitle)
			throws InterruptedException {

		Thread.sleep(5000);
		elementutil.waitForElementPresent(cc_btn, 10);
		elementutil.doClick(cc_btn);
		elementutil.waitForElementPresent(email_txt, 10);
		elementutil.doSendKeys(email, email_txt);
		elementutil.waitForElementPresent(first_name_txt, 5);
		elementutil.doSendKeys(firstname, first_name_txt);
		elementutil.waitForElementPresent(last_name_txt, 5);
		elementutil.doSendKeys(lastname, last_name_txt);
		elementutil.waitForElementPresent(job_title_txt, 5);
		elementutil.doSendKeys(jobtitle, job_title_txt);
		elementutil.waitForElementPresent(creat_contact_btn, 5);
		elementutil.doClick(creat_contact_btn);

	}

}
