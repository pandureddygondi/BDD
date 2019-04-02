package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auto57 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		//wait for visibility of userid
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.manage().window().maximize();
		//fill user-id
		driver.findElement(By.name("identifier")).sendKeys("pandueddy211");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		//wait for password
		driver.findElement(By.name("password")).sendKeys("9492375037");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		
		
	}

}
