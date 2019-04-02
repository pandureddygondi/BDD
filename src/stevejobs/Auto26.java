package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Auto26
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		//check drop down	
		WebElement e=driver.findElement(By.name("nights"));
		Select s =new Select(e);
		if (s.isMultiple()) 
		{
		System.out.println("multi-select");	
		}
		else
		{
			System.out.println("single-select");
		}
		
//close site
		driver.close();
	}

}
