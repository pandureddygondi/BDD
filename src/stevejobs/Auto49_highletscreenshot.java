package stevejobs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Auto49_highletscreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.id("mobileNo"));
		((JavascriptExecutor)driver).executeScript("arguments[0].value='9568995689';", e);
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px yellow dashed';",e);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\batch242\\amma.png");
		FileHandler.copy(src,dest);
		//close site
		driver.close();
	}

}
