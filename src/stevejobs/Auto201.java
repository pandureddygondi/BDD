package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto201 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().window().maximize();
		//count of items
		List<WebElement>l1=driver.findElements(By.xpath("(//*[@class='ui selection dropdown'])[1]/div[2]/div"));
		System.out.println(l1.size());
		List<WebElement>l2=driver.findElements(By.xpath("(//*[@class='ui fluid selection dropdown'])[1]/div[2]/div"));
		System.out.println(l2.size());
		List<WebElement>l3=driver.findElements(By.xpath("//*[@class='ui fluid dropdown selection multiple']/div[2]/div"));
		System.out.println(l3.size());
		//close site
		driver.close();

	}

}
