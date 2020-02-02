/*package HubSpotBase;

import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GridSetup extends BasePage {
	
WebDriver driver;
Properties prop = new Properties();
BasePage base = new BasePage();



public void desiredcaps_chrome() {
	base.getProperties();
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setBrowserName(prop.getProperty(""));
	caps.setPlatform(Platform.WIN10);
	//caps.setVersion("");
	caps.merge(getChromeOptions());	
}

public void desiredcaps_firefox() {
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setBrowserName(prop.getProperty("browser"));	
}


public static ChromeOptions getChromeOptions(){	
	ChromeOptions co = new ChromeOptions();
	co.addArguments("");
	co.addArguments("");
	return co;	
}


public static FirefoxOptions getFireFoxOptions(){
	
	FirefoxOptions fo = new FirefoxOptions();
	return fo;	
}








}
*/