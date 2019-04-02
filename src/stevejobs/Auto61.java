package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Auto61 
{

	public static void main(String[] args) throws InterruptedException
	{
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://in.bookmyshow.com");
		Thread.sleep(5000);
		/*WebElement e=driver.findElement(By.xpath("//*[@class='_fixed']"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		//close site
		driver.close();*/
		
	}

}
