package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test12demo {
	public static WebDriver driver;

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter browser name");
		String x=sc.nextLine();
		//launch site
		System.setProperty("webdriver.gecko.driver", "E:\\batch242\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.get("http:www.gmail.com");
		 driver.close();

	}

}
