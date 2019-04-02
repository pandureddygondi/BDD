package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class auto17 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert2");
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//*[text()='Try it']")).click();
		Thread.sleep(5000);
		String x=driver.switchTo().alert().getText();
         System.out.println(x);
         driver.switchTo().alert().accept();
         Thread.sleep(5000);
         driver.switchTo().defaultContent();
         //close site
         driver.close();
	}

}
