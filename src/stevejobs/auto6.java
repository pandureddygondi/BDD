package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class auto6 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
		String s=driver.getTitle();
		System.out.println(s);
		String k=driver.getPageSource();
	System.out.println(k);
	String j=driver.getCurrentUrl();
	
	System.out.println("current url of facebook page "+ j);
		driver.close();
		
		
			
	}

}
