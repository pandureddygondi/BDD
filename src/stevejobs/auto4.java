package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class auto4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.ie.driver","E:\\batch242\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		InternetExplorerDriver driver=new InternetExplorerDriver();
		driver.get("http://www.sentia.in/");
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("//*[contains(@src,'pay_online.jpg')]"));
		e.click();
		Thread.sleep(5000);
		WebElement f=driver.findElement(By.xpath("//*[contains(@href,'transportfee')][1]"));
		f.click();
		Thread.sleep(5000);
		driver.close();
	}

}

