package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dragdropauto38 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/slider");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement e1=driver.findElement(By.xpath("//*[@id='slider']/span"));
		Actions a=new Actions(driver);
		a.dragAndDropBy(e1,300, 0).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e1, -300, 0).build().perform();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Vertical slider")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		WebElement e2=driver.findElement(By.xpath("//*[@id='slider-vertical']/span"));
		a.dragAndDropBy(e2, 0, 50).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e2, 0, -100).build().perform();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}

}
