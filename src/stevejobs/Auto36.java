package stevejobs;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Auto36 {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter word");
		String x=sc.nextLine();
		System.out.println("enter expected suggestion");
		String y=sc.nextLine();
		
		//launch site
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys(x);
		Thread.sleep(5000);
		//cpllect items in cache
		Actions a=new Actions(driver);
		int flag=0;
		List<WebElement> l=driver.findElements(By.xpath("//*[@role='listbox']/li"));
		for(int i=0;i<l.size();i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			String v=driver.findElement(By.name("q")).getAttribute("value");
			if(v.equals(y))
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


