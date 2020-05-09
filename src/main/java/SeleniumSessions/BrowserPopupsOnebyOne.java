package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserPopupsOnebyOne {
	
	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("http://www.popuptest.com/goodpopups.html");
			driver.findElement(By.linkText("Good PopUp #1")).click();
			getTabTitle(driver);
			
			driver.findElement(By.linkText("Good PopUp #2")).click();
			getTabTitle(driver);
			
			driver.findElement(By.linkText("Good PopUp #3")).click();
			getTabTitle(driver);
			
			driver.findElement(By.linkText("Good PopUp #4")).click();
			getTabTitle(driver);
	}
	
	public static void getTabTitle(WebDriver driver){
		Set<String> handles =driver.getWindowHandles();
		Iterator<String> it =handles.iterator();
		String parentWindowId = it.next();
		System.out.println("parent window ID is: "+ parentWindowId);
		String childWindowId = it.next();
		System.out.println("Child window ID is: "+ childWindowId);
		driver.switchTo().window(childWindowId);
		System.out.println("child window title is: " +driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title is:" +driver.getTitle());
		
	}

}
