package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandlingUsingByLocator {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		By day = By.id("day");
		By month = By.id("month");
		By year = By.id("year");
		
		List<String> daysList = getDropdownValues(driver,day);
		System.out.println("the length of the Days list drop down is: "+daysList.size());
		System.out.println("the values in the Days list drop down are: "+daysList);
		
		List<String> monthList = getDropdownValues(driver,month);
		System.out.println("the length of the Days list drop down is: "+monthList.size());
		System.out.println("the values in the Days list drop down are: "+monthList);
		
		List<String> yearList = getDropdownValues(driver,year);
		System.out.println("the length of the Days list drop down is: "+yearList.size());
		System.out.println("the values in the Days list drop down are: "+yearList);
}

	public static List<String> getDropdownValues(WebDriver driver, By locator) {
		
		ElementUtil elementutil =new ElementUtil(driver);
		WebElement elementval =elementutil.getElement(locator);
		Select select = new Select(elementval); // now elementval has day/month/year
		
		List<WebElement> optionsList =select.getOptions(); //now optionsList has all the drop down list
		System.out.println("total values in drop down: "+optionsList.size());
		List<String> optionsValue = new ArrayList<String>();
		for(int i=0; i<optionsList.size(); i++) {
			optionsValue.add(optionsList.get(i).getText());
		}
		return optionsValue;
}
}
