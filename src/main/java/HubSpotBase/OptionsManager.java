package HubSpotBase;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsManager {
	
	
	public static ChromeOptions getChromeOptions(){
		ChromeOptions co = new ChromeOptions();
		co.addArguments("");
		co.addArguments("");
		return co;	
	}

	public static FirefoxOptions getFireFoxOptions(){	
		FirefoxOptions fo = new FirefoxOptions();
		FirefoxProfile prof = new FirefoxProfile();
		return fo;	
	}

	
	
	
	
	
	

}
