package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto2 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://gmail.com");
		Thread.sleep(5000);
		//do login
		driver.findElement(By.name("identifier")).sendKeys("pandureddy211");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("9492375037");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		//click compose and fill fields
		driver.findElement(By.xpath("//*[@class='a8k']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='z0']")).click();
		driver.findElement(By.name("to")).sendKeys("saiphanindrakoppuravuri092@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("wishes");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("hai frnd,belated happy new year ");
		driver.findElement(By.xpath("//*[text()='Send']")).click();
		
		Thread.sleep(5000);
		//do logout
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//close site
		driver.close();
		
		
		
	}

}
