package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); // with this step we no need to set the property
	
		WebDriver driver= new ChromeDriver();
		
		driver.get("http:\\www.google.com");
		
		System.out.println("the title of the page is: "+driver.getTitle());
		
		//driver.close();
		driver.quit();
		
		System.out.println(driver.getTitle());
		
		
	}

}
