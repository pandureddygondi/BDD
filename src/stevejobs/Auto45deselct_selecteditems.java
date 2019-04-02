package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Auto45deselct_selecteditems {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//click on multi dopdown
		driver.findElement(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]")).click();
		Thread.sleep(5000);
		//collect all items
		List<WebElement> l1=driver.findElements(By.xpath("//*[contains(@class,'active visible')]/div[2]/div"));
		//select 1st, 4th, 11th
		l1.get(0).click();
		Thread.sleep(5000);
		l1.get(3).click();
		Thread.sleep(5000);
		l1.get(10).click();
		Thread.sleep(5000);
		//de select selected items
		List<WebElement> l2=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]/a/i"));
		for(int i=0;i<l2.size();i++)
		{
			l2.get(i).click();
			Thread.sleep(5000);
		}
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}
