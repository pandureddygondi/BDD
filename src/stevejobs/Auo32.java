package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Auo32 {

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
		Actions a =new Actions(driver);
		
		WebElement e=driver.findElement(By.xpath("//*[@aria-label='Log In']"));
		a.click(e).build().perform();
		WebElement e2=driver.findElement(By.xpath("//*[@aria-labelledby='userNavigationLabel"));
		a.click(e2).build().perform();
		WebElement e3=driver.findElement(By.xpath("//*[text()='Log Out']"));
		a.click(e3).build().perform();
		//close site
		driver.close();
			
	}

}
