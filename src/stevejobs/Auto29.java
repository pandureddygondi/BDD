package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto29 {
	public static void main(String[] ags) throws InterruptedException
	{
		
		Scanner s=new Scanner(System.in);
		System.out.println("enter userid name");
		
		String x=s.nextLine();
		System.out.println("enter password name");
		String y=s.nextLine();
		
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		
		driver.findElement(By.name("identifier")).sendKeys(x,Keys.ENTER);
		//driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(y,Keys.ENTER);
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//*[text()='Next']")).isEnabled())
		{
			System.out.println("gmail site opened to use");
		}
		else
		{
		System.out.println("not working");	
		}
		
	}

}
