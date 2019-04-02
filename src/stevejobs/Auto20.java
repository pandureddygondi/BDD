package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto20 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
        driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement e = driver.findElement(By.name("q"));
		if(e.isDisplayed())
		{
			if(e.isEnabled()) 
			{
				System.out.println("searchbox displayed and enabled");
			}
			else
			{
				System.out.println("search box diplayed but not enabled ");
			}
		}
		else 
			{
				System.out.println("searchbox not displayed");
			}
		//close site
driver.close();
		}
	}


