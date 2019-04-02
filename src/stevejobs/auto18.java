package stevejobs;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class auto18 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
        driver.manage().window().maximize();
		Thread.sleep(5000);
		//switch to focused element
		driver.switchTo().activeElement().sendKeys("kalam");
		
		Thread.sleep(5000);
		driver.close();
	
	
	
	}

}
