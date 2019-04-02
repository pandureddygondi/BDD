package stevejobs;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class auto15 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.sentia.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@src,'pay_online.jpg')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@href,'transportfee')][1]")).click();
		Thread.sleep(5000);
		ArrayList a=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String) (a.get(1)));
		driver.close();
	}

}
