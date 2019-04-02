package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto43checkmultidrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
String x=driver.findElement(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]")).getAttribute("class");
if(x.contains("multiple"))
{
	System.out.println("multi select dropdown");
}
else
{
	System.out.println("single select dropdown");
}
//close site
driver.close();
	}

}
