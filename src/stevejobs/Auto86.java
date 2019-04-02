package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Auto86 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter userid");
		String uid=sc.nextLine();
		System.out.println("enter userid criteria");
		String uidc=sc.nextLine();
		String pwd="";
		String pwdc="";
		if(uidc.equalsIgnoreCase("valid"))
		{
			System.out.println("enter password");
			pwd=sc.nextLine();
			System.out.println("enter pwd criteria");
			pwdc=sc.nextLine();
			
		} 
		//create results file
		ExtentReports er=new ExtentReports("gmailtest2res.html",false);
		ExtentTest et=er.startTest("gmail userid testing");
		//launch site
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.manage().window().maximize();
		driver.findElement(By.name("identifier")).sendKeys(uid);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		//validations
				try
				{
					if(uid.length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Enter an email ')]")).isDisplayed())
					{
						et.log(LogStatus.PASS, "gmail blank userid test passed");
					}
					else if(uidc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'find your Google Account')])[2]")).isDisplayed())
					{
						et.log(LogStatus.PASS, "invalid userid test passed");
					}
					else if(uidc.equalsIgnoreCase("valid") && driver.findElement(By.name("password")).isDisplayed())
					{
						et.log(LogStatus.PASS, "valid userid test passed");
		               //passwod testing
						driver.findElement(By.name("password")).sendKeys(pwd);
						w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
						driver.findElement(By.xpath("//*[text()='Next']")).click();
						Thread.sleep(5000);
						if(pwd.length()==0 && driver.findElement(By.xpath("//*[text()='Enter a password']")).isDisplayed())
						{
							et.log(LogStatus.PASS, "blank password test passed");
						}
						else if(pwdc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).isDisplayed())
						{
							et.log(LogStatus.PASS, "invalid password test passed");
						}
						else if(pwdc.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='Compose']")).isDisplayed())
						{
							et.log(LogStatus.PASS, "valid password test passed");
						}
						else
						{
							SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
					    	 Date d=new Date();
					    	 String fname=sf.format(d)+".png";
					    	 File src=driver.getScreenshotAs(OutputType.FILE);
					    	 File dest=new File(fname);
					    	 FileHandler.copy(src, dest);
					    	 et.log(LogStatus.FAIL, "gmail password test failed"+et.addScreenCapture(fname));
						}
						

	}
					else
					{
						SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
				    	 Date d=new Date();
				    	 String fname=sf.format(d)+".png";
				    	 File src=driver.getScreenshotAs(OutputType.FILE);
				    	 File dest=new File(fname);
				    	 FileHandler.copy(src, dest);
				    	 et.log(LogStatus.FAIL, "gmail userid test failed"+et.addScreenCapture(fname));
					}

}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
				//close site
				driver.close();
				//save results
				er.endTest(et);
				er.flush();
	}
}
				
