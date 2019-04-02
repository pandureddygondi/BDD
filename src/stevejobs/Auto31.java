package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto31 {

	public static void main(String[] args) throws InterruptedException {

		Scanner s=new Scanner(System.in);
		System.out.println("enter userid name");
		String x=s.nextLine();
		System.out.println("enter password name");
		
		String y=s.nextLine();
		
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys(x);;

		Thread.sleep(5000);
		driver.findElement(By.name("pass")).sendKeys(y);;
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//*[@aria-label='Log In']")).isEnabled()) {
			System.out.println("succesful login");
		}
		else
		{
			System.out.println("failed");
			
		}
		//close site
		driver.close();
	}

}
