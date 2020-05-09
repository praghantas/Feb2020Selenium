package SeleniumSessions;

public class FacebookTest {

	public static void main(String[] args) {
		
		CrossBrowserTesting cr = new CrossBrowserTesting();
		cr.launchBrowser("chrome");
		cr.launchUrl("http:\\www.facebook.com");
		//cr.launchUrl("https:\\www.google.com");
		String title = cr.getTitle();
		System.out.println(title);
		if(title.contains("Facebook")) 
			System.out.println("Facebook launched successfully");
		
		else
			System.out.println("incorrect page title. please pass correct url");
		
		cr.quitBrowser();
	}

}
