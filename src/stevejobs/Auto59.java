package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auto59 
{
 public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a word");
		String x=sc.nextLine();
		//launch site
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.Angularjs.org");
		//wait for angular-js based text-box visibility
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Name:'])[2]/following-sibling::input")));
		driver.manage().window().maximize();
		//fill text box with keyboard data
		driver.findElement(By.xpath("(//*[text()='Name:'])[2]/following-sibling::input")).sendKeys(x);
		
		//wait for message ready
		w.until(ExpectedConditions.textToBe(By.xpath("(//*[starts-with(text(),'Hello')])[2]"), "Hello "+x+"!"));
         // get message and display
		String y=driver.findElement(By.xpath("(//*[starts-with(text(),'Hello')])[2]")).getText();
		System.out.println(y);
		//close site
		driver.close();
	}

}
