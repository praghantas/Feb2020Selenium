package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorConcept {
	
	       static By emailid = By.id("username");
	       static By pswrd = By.id("password");
	       static By loginbutton =By.id("loginBtn");
	      // static By homePageHeader = By.cssSelector("h1.private-page__title");
	
	public static void main(String args[]) throws InterruptedException {
		BrowserActions br =new BrowserActions();
		WebDriver driver=br.launchBrowser("chrome");
		br.launchUrl("https://app.hubspot.com/login");
		Thread.sleep(5000);
		ElementUtil elementUtil = new ElementUtil(driver);
		elementUtil.doSendKeys(emailid, "pranitha@gmail.com");
		elementUtil.doSendKeys(pswrd, "Test@123");
		elementUtil.doClick(loginbutton);
		Thread.sleep(6000);
		/**String header = elementUtil.doGetText(homePageHeader);
		System.out.println("home page header is : "+ header);
		
		if(header.contains("Sales Dashboard")){
			System.out.println("user has logged in successfully....");
		}else{
			System.out.println("could not login");
		}
		
		System.out.println(br.doGetTitle()); **/
		
		
	}
}
