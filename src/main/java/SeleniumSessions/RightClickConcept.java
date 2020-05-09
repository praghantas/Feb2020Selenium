package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		Thread.sleep(4000);
		WebElement rightClickMe =driver.findElement(By.xpath("//span[text()='right click me']"));
		List<WebElement> optionsList =driver.findElements(By.xpath("//ul/li[contains(@class,'context-menu-icon')]/span"));
		System.out.println(optionsList);
		List<String> rightClickOptionsList =getRightClickOptions(driver,optionsList,rightClickMe);
		System.out.println("the options in the right click menu: "+rightClickOptionsList);
		doRightClick(driver,optionsList,rightClickMe,"Copy");
	}
	
	public static List<String> getRightClickOptions(WebDriver driver, List<WebElement> optionsList, WebElement rightClickMe ) {
		List<String> ar = new ArrayList<String>();
		Actions action = new Actions(driver);
		action.contextClick(rightClickMe).build().perform();
	 	System.out.println("the number of options in the right click menu:"+optionsList.size());
		for(int i=0; i<optionsList.size();i++) {
		String optionName =optionsList.get(i).getText();
		//System.out.println(i+"---->"+optionName);
		ar.add(optionName);
		}
		return ar;
	}
	
	public static void doRightClick(WebDriver driver, List<WebElement> optionsList, WebElement rightClickMe, String value) {
		Actions action = new Actions(driver);
		action.contextClick(rightClickMe).build().perform();
	 	//System.out.println("the number of options in the right click menu:"+optionsList.size());
		for(int i=0; i<optionsList.size();i++) {
		String optionName =optionsList.get(i).getText();
		//System.out.println(i+"---->"+optionName);
		
		if(optionName.equals(value)) {
			optionsList.get(i).click()
			;
			break;
		}
		}
	}
}