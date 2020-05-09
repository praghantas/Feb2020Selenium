package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Sign up")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='uid-firstName-5']")).sendKeys("Pranitha");
		driver.findElement(By.xpath("//input[@id='uid-lastName-6']")).sendKeys("Ghantasala");
		driver.findElement(By.xpath("//input[@id='uid-email-7']")).sendKeys("pranitha@gmail.com");
		
		Thread.sleep(5000); //system is taking time, so kept the wait 
		driver.findElement(By.className("layout-submit-button")).click();
		
		
	}

}
