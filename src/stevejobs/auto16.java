package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class auto16 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker");
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("11/17/2018");
		Thread.sleep(5000);
		driver.close();

	}

}
