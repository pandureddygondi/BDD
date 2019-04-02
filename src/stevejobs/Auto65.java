package stevejobs;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.sun.glass.events.KeyEvent;

public class Auto65 
{

	public static void main(String[] args) throws Exception 
	{
		//launch site
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(co);
		driver.get("http://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[name=email]")).sendKeys("pandureddy211@gmail.com");
		driver.findElement(By.cssSelector("input[name=pass]")).sendKeys("pandu143");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		WebElement e=driver.findElement(By.xpath("//*[@id='userNavigationLabel']"));
				Actions a=new Actions(driver);
				a.click(e).build().perform();
		//close site
				driver.close();
		
	}

}
