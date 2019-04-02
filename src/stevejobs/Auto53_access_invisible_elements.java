package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto53_access_invisible_elements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		List<WebElement> l=driver.findElements(By.xpath("//*[@class='ui fluid dropdown selection multiple']/div[2]/div"));
for(int i=0;i<l.size();i++)
{
	((JavascriptExecutor)driver).executeScript("var x=arguments[0].textContent;alert(x);",l.get(i));
	String y=driver.switchTo().alert().getText();
	System.out.println(y);
	Thread.sleep(5000);
	driver.switchTo().alert().dismiss();
}
//close site
driver.close();
	}

}
