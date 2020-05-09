package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		WebElement element=driver.findElement(locator);
		return element;
	}
	/**
	 * this method retuns the list of webelements
	 * @param locator
	 * @return
	 */
	public List<WebElement> getElements(By locator) {
		List<WebElement> elements =driver.findElements(locator);
		return elements;
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	/**
	 * including the generic methods in this class, for further usage
	 * this method is to get the dropdown values 
	 * @param locator
	 */
	public void getDropdownValues(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList =select.getOptions();
		System.out.println("total values in the drop down: "+optionsList.size());
		for(int i=0;i<optionsList.size();i++) {
			System.out.println(optionsList.get(i).getText());
		}
		
	}
	/**
	 * to select the value from dropdown using direct Select methods
	 * @param locator
	 * @param value
	 */
	public void selectDropdown(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
		
	}
	
	/**
	 * to select the value from dropdown using direct Select methods
	 * @param locator
	 * @param index
	 */
		public void selectDropdown(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	/**
	 * below method is to select the given value from the drop down
	 * @param locator
	 * @param value
	 */
	public void selectDropdownValue(By locator, String value) {
		
		Select select = new Select(getElement(locator));
		List<WebElement> valuesList =select.getOptions();
		System.out.println("drop down list size is: "+valuesList.size());
		
		for(int i=0; i<valuesList.size();i++) {
			if(valuesList.get(i).getText().equals(value)){
				valuesList.get(i).click();
				break;
			}
		}
	}	
	
	/**
	 * below method returns the List of drop down values using Select class from selenium
	 * @param locator
	 * @return
	 */
	
	public List<String> getDropdownValuesList(By locator) {
		
		Select select = new Select(getElement(locator)); 
		List<WebElement> optionsList =select.getOptions(); //now optionsList has all the drop down list
		System.out.println("total values in drop down: "+optionsList.size());
		List<String> optionsValue = new ArrayList<String>();
		for(int i=0; i<optionsList.size(); i++) {
			optionsValue.add(optionsList.get(i).getText());
		}
		return optionsValue;
	}
	
	/**
	 * this method is to select the value from drop down without using default Select class from selenium
	 * @param locator
	 * @param locatorValue
	 * @param value
	 */
	
	public void selectDropdownValueswithXpath(String locator, String locatorValue, String value) {
		List<WebElement> valuesList = null;
		
		if (locator.equals("xpath")) {
			valuesList = driver.findElements(By.xpath(locatorValue));
		}
		else if (locator.equals("css")) {
			valuesList = driver.findElements(By.cssSelector(locatorValue));
		}
		System.out.println(valuesList.size());
		for (int i = 0; i < valuesList.size(); i++) {
			if (valuesList.get(i).getText().equals(value)) {
				valuesList.get(i).click();
				break;
			}
		}
		
	}
	/**
	 * the below method helps to click on the option from the right click menu
	 * @param optionsList
	 * @param rightClickMe
	 * @param value
	 */
	
	public void doRightClick(List<WebElement> optionsList, WebElement rightClickMe, String value) {
		Actions action = new Actions(driver);
		action.contextClick(rightClickMe).build().perform();
	 	//System.out.println("the number of options in the right click menu:"+optionsList.size());
		for(int i=0; i<optionsList.size();i++) {
		String optionName =optionsList.get(i).getText();
		//System.out.println(i+"---->"+optionName);
		
			if(optionName.equals(value)) {
			optionsList.get(i).click();
			break;
			}
		}
	}
	/**
	 * the below method helps to return the options list of the right click menu
	 * @param optionsList
	 * @param rightClickMe
	 * @return
	 */

	public List<String> getRightClickOptions(List<WebElement> optionsList, WebElement rightClickMe ) {
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
	
	
	public List<WebElement> visiblilityOfAllElements(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator)));
		return driver.findElements(locator);
	}

	public WebElement waitForElementToBePresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return getElement(locator);
	}

	public WebElement waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return getElement(locator);
	}

	public WebElement waitForElementToBeVisbile(By locator, int timeout) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public WebElement waitForElementVisibilityLocated(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return getElement(locator);
	}

	public String waitForUrl(String url, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.urlContains(url));
		return driver.getCurrentUrl();
	}

	public boolean waitAlertToBePresent(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.alertIsPresent());
		return true;
	}

	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).click();
	}

	public String waitForTitleToBePresent(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
}
