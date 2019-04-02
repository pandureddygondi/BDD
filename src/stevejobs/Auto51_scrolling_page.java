package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto51_scrolling_page {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//scroll to bottom
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(10000);
		//scroll to top
		((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight,0);");
		Thread.sleep(10000);
		//scroll to specific element
		WebElement e=driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']"));
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",e);
		//close site
		driver.close();
	}

}
