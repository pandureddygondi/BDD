package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class auto13 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		//do login
		driver.findElement(By.name("identifier")).sendKeys("pandureddy211");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("9492375037");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		//goto checkbox count of all mails(rows)
		List<WebElement>l=driver.findElements(By.xpath("(//table)[4]/tbody/tr"));
		System.out.println(l.size());
	//select checkbox 5th row(mail)
		driver.findElement(By.xpath("(//table)[4]/tbody/tr[5]/td[2]/div")).click();
		Thread.sleep(5000);
		//do logout
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//close site
		driver.close();
		
	}

}
