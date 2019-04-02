package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class auto3 {

	public static void main(String[] args) throws InterruptedException 
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter browser name");
		String x=sc.nextLine();
		WebDriver driver;
		if(x.equals("chrome"))
		{
			//define object to corresponding class
			System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(x.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\batch242\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		else if(x.equals("ie")) {
			System.setProperty("webdriver.ie.driver","E:\\batch242\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}
		else {
			OperaOptions ff=new OperaOptions();
			ff.setBinary("C:\\Users\\Dell\\AppData\\Local\\Programs\\Opera\\launcher.exe");
			System.setProperty("webdriver.opera.driver", "E:\\batch242\\operadriver_win64\\operadriver_win64\\operadriver.exe");
			 driver=new OperaDriver(ff);
		}
		
		driver.get("http://www.sentia.in/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@src,'pay_online.jpg')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@href,'transportfee')][1]")).click();
		Thread.sleep(5000);
		driver.quit();//close all windows
		//driver.close();//close current window
	}
	

}
