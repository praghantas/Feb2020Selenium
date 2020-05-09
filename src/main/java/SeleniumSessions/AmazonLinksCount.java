package SeleniumSessions;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLinksCount {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		List<WebElement> linkList= driver.findElements(By.tagName("a"));
		
		int totalLinks = linkList.size();
		System.out.println("total number of links: "+totalLinks);
		
		for(int i=0; i<totalLinks;i++) {
			String linkName =linkList.get(i).getText();
			if(!linkName.isEmpty()) {
				System.out.print(i+"------"+linkName+"----------");
				System.out.println(linkList.get(i).getAttribute("href"));
			}
		}

	}

}
