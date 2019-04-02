package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Auto25 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//navigate to gmail
		driver.navigate().to("http://www.gmail.co.in");
		Thread.sleep(5000);
		//return to google
		driver.navigate().back();
		Thread.sleep(5000);
		//forword to gmail
		driver.navigate().forward();
		Thread.sleep(5000);
		//refresh gmail
		driver.navigate().refresh();
		Thread.sleep(5000);
		//CLOSE SITE
		driver.close();
	
	}

}
