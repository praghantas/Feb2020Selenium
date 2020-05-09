package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RIghtClickUsingByLocator {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		By rightClickMe = By.xpath("//span[text()='right click me']");
		By option = By.xpath("//ul/li[contains(@class,'context-menu-icon')]/span");
		
		ElementUtil elementUtil = new ElementUtil(driver);
		
		WebElement righClick =elementUtil.getElement(rightClickMe);
		List<WebElement> optionsList=elementUtil.getElements(option);
		
		List<String> optionsValueList =elementUtil.getRightClickOptions(optionsList, righClick);
		
		System.out.println("the total number of options in the right click menu is:"+optionsValueList.size());
		System.out.println("the options values of the right click menu are:"+optionsValueList );
		
		elementUtil.doRightClick(optionsList, righClick, "Copy");
		System.out.println("the Copy option got clicked");
		
	}

}
