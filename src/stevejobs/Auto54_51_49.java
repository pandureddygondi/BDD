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

public class Auto54_51_49 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//scroll to bottom
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(10000);
		//scroll to top
		((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight,0);");
		Thread.sleep(10000);
		//scroll to specific element
		WebElement e=driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']"));
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",e);
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px yellow dashed';",e);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\batch242\\nana.png");
		FileHandler.copy(src,dest);
	}

}
