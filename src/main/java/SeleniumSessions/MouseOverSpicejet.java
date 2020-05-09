package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverSpicejet {

	public static void main(String[] args) throws InterruptedException  {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
		WebElement contentLink1 = driver.findElement(By.id("ctl00_HyperLinkLogin"));
		mouseOveronContent(driver, contentLink1);
		Thread.sleep(3000);
		
		WebElement contentLink2 =driver.findElement(By.linkText("SpiceClub Members"));
		mouseOveronContent(driver, contentLink2);
		
		driver.findElement(By.linkText("Member Login")).click();
	}

	public static void mouseOveronContent(WebDriver driver, WebElement contentLink) {
		Actions action = new Actions(driver);
		action.moveToElement(contentLink).build().perform();
	}
}
