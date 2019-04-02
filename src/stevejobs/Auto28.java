package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Auto28 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		WebElement e=driver.findElement(By.name("nights"));
		Select s=new Select(e);
		//s.selectByVisibleText("4Nights+5Days");
		//s.selectByIndex(4);
		s.selectByValue("4Nights / 5Days");
		Thread.sleep(5000);
		//close sit
		driver.close();

	}
	

}
