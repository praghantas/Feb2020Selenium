package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CrossBrowserTesting {
		WebDriver driver;

	public void launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			break;
		case "IE":
		    WebDriverManager.iedriver().setup();
		    driver = new InternetExplorerDriver();
		    break;
		default:
			System.out.println("please provide correct browser name:"+browser);
			break;
		
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}	
	public void launchUrl(String url) {
		driver.get(url);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	}


