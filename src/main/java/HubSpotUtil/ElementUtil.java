package HubSpotUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HubSpotBase.BasePage;

public class ElementUtil extends BasePage {

	WebDriver driver;

	WebElement element;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method will return
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {

		WebElement element = null;
		try {
			wait(locator, 20);
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Some exception occured while getting an element" + locator);
			System.out.println(e.getMessage());
		}

		return element;

	}

	/**
	 * This method will do click operation on the Web Element
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {

		try {
			wait(locator, 20);
			getElement(locator).click();

		} catch (Exception e) {
			System.out.println("Some exception occured while clicking the element" + locator);
			System.out.println(e.getMessage());
		}

	}

	/**
	 * 
	 * @param value
	 * @param locator
	 */
	public void doSendKeys(String value, By locator) {

		try {
			wait(locator, 20);
			driver.findElement(locator).clear();
			driver.findElement(locator).click();
			getElement(locator).sendKeys(value);

		} catch (Exception e) {

			System.out.println("Some exception occured while sending keys to " + locator);
			System.out.println(e.getMessage());

		}
	}

	/**
	 * 
	 * @param targetlocator
	 * @param timeouts
	 */
	public void moveToElement(WebElement targetlocator, int timeouts) {
        
			
		try {
			Actions act = new Actions(driver);
			act.moveToElement(targetlocator);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	/**
	 * Accepts alert pop-up
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();

	}

	/**
	 * Dismisses alert pop-up
	 */
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will upload a file
	 * 
	 * @param locator
	 * @param timeouts
	 * @param path
	 */

	public void uploadFile(By locator, int timeouts, String path) {
		try {
			wait(locator, 10);
			getElement(locator).sendKeys(path);
		} catch (Exception e) {
			System.out.println("Some exception occured while uploading a file");
			System.out.println(e.getMessage());
		}

	}

	/**
	 * 
	 * @param locator
	 * @return
	 */
	public boolean isElementDisplayed(By locator) {

		try {
			wait(locator, 20);
			getElement(locator).isDisplayed();
			return true;

		} catch (Exception e) {
			System.out.println("Some Exception occured while element is being displayed");
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * 
	 * @param locator
	 * @return
	 */
	public String getText(By locator) {
		wait(locator, 30);
		String text = getElement(locator).getText();
		return text;
	}

	/**
	 * 
	 * @param locator
	 */
	public void moveToTargetElement(By locator) {

		try {
			wait(locator, 20);
			Actions act = new Actions(driver);
			act.moveToElement(getElement(locator));
		} catch (Exception e) {
			System.out.println("Some exception occured while moving to the target element");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param sourceloctor
	 * @param targetlocator
	 */

	public void dragAndDrop(By sourceloctor, By targetlocator) {

		try {
			wait(sourceloctor, 20);
			Actions act = new Actions(driver);
			act.dragAndDrop(getElement(sourceloctor), getElement(targetlocator));

		} catch (Exception e) {
			System.out.println(
					"Some exception occured while performing drag and drop operation" + sourceloctor + targetlocator);
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	
	public WebDriverWait wait(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return wait;
	}

	
	
	public String getPageTitle() {
		
		try {
			String pageTitle = driver.getTitle();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleIs(pageTitle));
			
			return pageTitle;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	
	
	
	public void waitForElementPresent(By locator,int timeout) {
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	
	
	
}
