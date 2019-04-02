package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Auto33 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		WebElement e=driver.findElement(By.name("q"));
		Actions a=new Actions(driver);
		a.sendKeys(e,"kohli").build().perform();
		
Thread.sleep(5000);
		//close site
		driver.close();
	}

}
