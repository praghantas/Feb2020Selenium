package SeleniumSessions;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowTab {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.linkText("Good PopUp #2")).click();
		
		Set<String> handles =driver.getWindowHandles();
		List<String> handleListforTabs = new ArrayList<String>(handles);
		System.out.println("parent window id is: "+handleListforTabs.get(0));
		System.out.println("parent window title is: "+driver.getTitle());
		
		System.out.println("child window id is: "+handleListforTabs.get(1)); //switching from parent window tab to next tab
		driver.switchTo().window(handleListforTabs.get(1));
		System.out.println("child window title is: "+driver.getTitle());
		
		System.out.println("parent window id is: "+handleListforTabs.get(0)); //switching from child window tab to parent window
		
		driver.switchTo().window(handleListforTabs.get(0)); // switching 
		System.out.println("parent window title is: "+driver.getTitle());
		
	}

}
