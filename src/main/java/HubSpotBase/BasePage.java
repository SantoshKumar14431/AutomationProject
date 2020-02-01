package HubSpotBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;

	Properties prop;

	public WebDriver initialization(String browsername) {
		//getProperties(prop);
		if (browsername.equals(("chrome"))) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		return driver;
	
	}
	
	public Properties getProperties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\SantoshFramework\\src\\main\\java\\HubSpotConfig\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
