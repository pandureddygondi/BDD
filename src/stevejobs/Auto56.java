package stevejobs;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auto56 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/calendar/overview/defaultcs.aspx");
		
		//wait for visibility of calendar
		FluentWait w=new FluentWait(driver);
		Duration d1=Duration.of(1, ChronoUnit.SECONDS);
		w.pollingEvery(d1);
		Duration d2=Duration.of(20, ChronoUnit.SECONDS);
		w.withTimeout(d2);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("rcMainTable)")));
		driver.manage().window().maximize();
		//select a day
		driver.findElement(By.xpath("//*[text()='10']")).click();
		//wait for invisibility of icon
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("raDiv")));
		//close site
		driver.close();
		
	}

}
