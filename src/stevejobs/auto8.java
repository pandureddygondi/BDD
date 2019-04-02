package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class auto8 {

	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
ChromeDriver driver=new ChromeDriver();
driver.get("https://www.google.co.in");
Thread.sleep(5000);
//driver.findElement(By.name("q")).sendKeys("kalam",Keys.ENTER);
//driver.findElement(By.name("q")).sendKeys("kalam",Keys.chord(Keys.CONTROL,"A"));
String x=driver.findElement(By.name("q")).getAttribute("maxlength");

System.out.println(x);

driver.close();
	}

}
