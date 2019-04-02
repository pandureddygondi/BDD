package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auto58 {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a word");
		String x=sc.nextLine();
		
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.Angularjs.org");
		//wait for Angularjs based text box visibility
		WebDriverWait w=new WebDriverWait(driver,20);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Name:'])[2]"))));
		driver.manage().window().maximize();
	}

}
