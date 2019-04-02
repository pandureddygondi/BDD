package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Auto46_ {

	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement e=driver.findElement(By.id("mobileNo"));
		driver.executeScript("arguments[0].value='9568995689';", e);
		driver.executeScript("arguments[0].style.border='2px white dashed';",e);
		
		//close site
		
		driver.close();
		
	}

}
