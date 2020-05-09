package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLanguaugeLinks {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		List<WebElement> linkList=driver.findElements(By.xpath("//div[@id='SIvCob']/a")); // this is to get the count of languages
		
		for(int i=0; i<linkList.size();i++) {
			// we take the list of links every time, so we get the correct links as page gets refresh every time
		List<WebElement> linkList1=driver.findElements(By.xpath("//div[@id='SIvCob']/a")); 
		String linkText =linkList1.get(i).getText();
		System.out.println(linkText);
		}
	
	}

}
