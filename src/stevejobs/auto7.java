package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class auto7 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
driver.get("https://www.irctc.co.in");
Thread.sleep(5000);
String x=driver.getCurrentUrl();
System.out.println("current url of irctc "+x);
		

	}

}
