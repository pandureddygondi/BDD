package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class auto14 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		Thread.sleep(5000);
		//get all images count
	List<WebElement>l=driver.findElements(By.xpath("(//img)|(//input[@type='image'])"));
	System.out.println(l.size());
	//close site
driver.close();
	}

}
