package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandleWithSelect {

	public static void main(String[] args) {
				
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		/*Select select = new Select(day);  // we need to use select class to select drop down buttons
		select.selectByValue("14");
		select.selectByVisibleText("12");
		select.selectByIndex(10);
		
		Select select1 = new Select(month);
		select1.selectByVisibleText("Jul");
		select1.selectByValue("6");
		select1.selectByIndex(2);*/
		
		selectDropdown(day, "15");
		selectDropdown(day, 5); //method overloading with different parameters 
		selectDropdown(month, "May");
		
		//Select select = new Select(day);
		//System.out.println(select.isMultiple()); // to check if the dropdown is single value select or multi value
		
		getDropdownValues(day);
		getDropdownValues(month);
		
	}
	
	public static void getDropdownValues(WebElement element) {
		Select select = new Select(element);
		List<WebElement> optionsList =select.getOptions();
		System.out.println("total values in the drop down: "+optionsList.size());
		for(int i=0;i<optionsList.size();i++) {
			System.out.println(optionsList.get(i).getText());
		}
		
	}
	
	public static void selectDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}
	public static void selectDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

}
