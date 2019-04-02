package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Auto91 
{
	public static void main(String[] args) throws Exception
	{
		//get word to search from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a word");
		String x=sc.nextLine();
		
		//create results file
		ExtentReports er=new ExtentReports("googletestres2.html",false);
		ExtentTest et=er.startTest("google pagination testing");
		//launch site
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='NO, THANKS']")).click();
		Thread.sleep(5000);
		//pagination
		int flag=0; //null value
		String fname="";
		while(2>1)
		{
			String t=driver.getTitle();
			if(!t.contains(x))
			{
				flag=1;
				//take screenshot
				SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
				Date d=new Date();
				fname=sf.format(d);
				File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File(fname);
				FileHandler.copy(src, dest);
			}
			//go to next page
			try
			{
				if(driver.findElement(By.xpath("//*[text()='Next']")).isDisplayed())
				{
					driver.findElement(By.xpath("//*[text()='Next']")).click();
					Thread.sleep(3000);
				}
			}
			catch(Exception ex)
			{
				break;//terminated
			}
			
		}
		if (flag==0)
		{
			et.log(LogStatus.PASS, "google title test passed");
		}
		else
		{
		   et.log(LogStatus.FAIL, "google title test failed"+et.addScreenCapture(fname));	
		}
		//close site
		driver.close();
		//save results
		er.endTest(et);
		er.flush();

	}

}
