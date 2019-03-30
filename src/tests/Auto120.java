package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Auto120 
{
	public WebDriver driver;
	@Test(priority=1)
	public void launch()
	{
		//open browser
		   System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
	}
	@Test(priority=2)
	public void site()
	{
		
		driver.get("https://www.gmail.com");
	}
	
	@Test(priority=3)
	public void validation()
	{
		String y=driver.getTitle();
		if(y.equals("Gmail"))
		{
			Reporter.log("title test passed");
		}
		else
		{
			Reporter.log("test failed");
		}
	}
	@Test(priority=4)
	   public void closesite()
	   {
		   driver.close();
	   }

}
