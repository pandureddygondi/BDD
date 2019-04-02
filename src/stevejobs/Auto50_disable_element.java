package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto50_disable_element {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.id("mobileNo"));
		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('Disabled','true');",e);
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('Disabled');",e);
		Thread.sleep(5000);
		//close site
		driver.close();
	}

}
