package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class auto11 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		driver.findElement(By.name("field-keywords")).sendKeys("Redminote5pro",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Redmi 6 Pro (Black, 4GB RAM, 64GB Storage)']")).click();
		Thread.sleep(5000);
		driver.close();
	}
}

