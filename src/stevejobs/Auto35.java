package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Auto35 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\\\batch242\\\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("virat");
		Thread.sleep(5000);
		Actions a=new Actions(driver);
		int flag=0;
		for(int i=1;i<=10;i++)
		{
			
		a.sendKeys(Keys.DOWN).build().perform();
		String x=driver.findElement(By.name("q")).getAttribute("value");
		if(x.equals("virat kohli photos"))
		{
			flag=1;
		}
		Thread.sleep(5000);
		}
		if(flag==1) 
		{
			System.out.println("item found in cache");
		}
		else
		{
			System.out.println("item not found in cache");
		}
		//close site
		driver.close();
		}
	}

