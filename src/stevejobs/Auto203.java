package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Auto203 {

	public static void main(String[] args) throws Exception
	{
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-Notifications");
		
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver(co);
		
		driver.get("https://www.goibibo.com");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Hyderabad (HYD)");
		driver.findElement(By.xpath("//span[normalize-space()='Hyderabad']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class='container'])[1]/a/i")).click();
	
	
		driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Delhi (DEL)");
		driver.findElement(By.xpath("//span[normalize-space()='Delhi']")).click();
		
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@id,'webklipper-publisher')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='15']")).click();
	
		driver.findElement(By.xpath("//button[text()='SEARCH']")).click();
	
			

	}

}
