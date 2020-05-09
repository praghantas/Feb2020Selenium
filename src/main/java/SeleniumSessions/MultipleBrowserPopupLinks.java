package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowserPopupLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.linkText("Good PopUp #1")).click();
		driver.findElement(By.linkText("Good PopUp #2")).click();
		driver.findElement(By.linkText("Good PopUp #3")).click();
		driver.findElement(By.linkText("Good PopUp #4")).click();
		
		Set<String> handles = driver.getWindowHandles();
		List<String> handlesListforTabs = new ArrayList<String>(handles);
		
		System.out.println("parent window tab id is: "+handlesListforTabs.get(0));
		System.out.println("parent window tab title is: "+driver.getTitle());
		
		getTabTitle(driver, handlesListforTabs);
		
	/*	System.out.println("child1 window tab id is: "+handlesListforTabs.get(1));
		System.out.println("child2 window tab id is: "+handlesListforTabs.get(2));
		System.out.println("child3 window tab id is: "+handlesListforTabs.get(3));
		System.out.println("child4 window tab id is: "+handlesListforTabs.get(4));
		driver.switchTo().window(handlesListforTabs.get(1));
		System.out.println("child window title is "+ driver.getTitle());
		driver.switchTo().window(handlesListforTabs.get(2));
		System.out.println("child window title is "+ driver.getTitle());
		driver.switchTo().window(handlesListforTabs.get(3));
		System.out.println("child window title is "+ driver.getTitle());
		driver.switchTo().window(handlesListforTabs.get(4));
		System.out.println("child window title is "+ driver.getTitle()); */
}

/**
 * this method provides id and title of all the child tabs opened from popuptest page
 * @param driver
 * @param handlesListforTabs
 */
	public static void getTabTitle(WebDriver driver,List<String> handlesListforTabs){
	
		for(int i=1; i<=handlesListforTabs.size();i++) {
		
		System.out.println("child" +i+ "window tab id is: " +handlesListforTabs.get(i));
		driver.switchTo().window(handlesListforTabs.get(i));
		System.out.println("child window title is "+ driver.getTitle());
	  }
	}	
}
