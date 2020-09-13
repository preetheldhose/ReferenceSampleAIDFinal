/**
 * 
 */
package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author Preeth Eldhose
 *
 */
public class BrowserFactory {
	
	WebDriver driver;
	
	public  WebDriver startBrowser(String browserName, String url) {
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			
			System.setProperty("webdriver.chrome.driver", "/Users/preetheldhose/Desktop/Bismallah/Work/Software/chromeDriver/85/chromedriver");  
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options); 

			
		} else if(browserName.equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
			
		} else if(browserName.equalsIgnoreCase("safari")) 
		{
			driver=new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}

}
