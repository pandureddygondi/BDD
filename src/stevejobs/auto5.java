package stevejobs;

import org.openqa.selenium.By;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class auto5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.ie.driver","E:\\batch242\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		InternetExplorerDriver driver=new InternetExplorerDriver();
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("pandureddy211@gmail.com");
		
		driver.findElement(By.name("pass")).sendKeys("pandu143");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@aria-label='Log In']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@aria-labelledby='userNavigationLabel']")).click();
	}

}
