package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto202
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//*[@class='ui dropdown selection'])[1]")).click();
		Thread.sleep(5000);
		List<WebElement>l1=driver.findElements(By.xpath("//*[contains(@class,'active visible')]/div[2]/div"));
		int n=l1.size();
		for(int i=0;i<n;i++)
		{
			System.out.println(l1.get(i).getText());
			
		}
        driver.close();
	}

}
