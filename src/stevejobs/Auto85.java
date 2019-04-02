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

public class Auto85 
{
	public static void main(String[] args) throws Exception
	{
		//get data from keyword
		Scanner sc=new Scanner(System.in);
		System.out.println("enter mobile number");
		String mbno=sc.nextLine();
		System.out.println("enter mobile number criteria");
		String mbnoc=sc.nextLine();
		System.out.println("enter password");
		String pwd=sc.nextLine();
		System.out.println("enter password criteria");
		String pwdc=sc.nextLine();
		//create results file
		ExtentReports er=new ExtentReports("w2smstestres.html",false);
		ExtentTest et=er.startTest("w2sms login testing");
		//launch site
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		driver.manage().window().maximize();
		driver.findElement(By.name("mobileNo")).sendKeys(mbno);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys(pwd);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),' Login ')]")));
		driver.findElement(By.xpath("//*[contains(text(),' Login ')]")).click();
		Thread.sleep(5000);
		//validations
		try
		{
			if(mbno.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
			{
				et.log(LogStatus.PASS, "blank mbno test passed");
			}
			else if(mbno.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
			{
				et.log(LogStatus.PASS, "wong size mbno test passed");
			}
			else if(pwd.length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[2]")).isDisplayed())
			{
				et.log(LogStatus.PASS, "blank password test passed");
			}
			else if(mbnoc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),' not register ')])[1]")).isDisplayed())
			{
				et.log(LogStatus.PASS, "invalid mbno test passed");
			}
			else if(mbnoc.equalsIgnoreCase("valid") && pwdc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
			{
				et.log(LogStatus.PASS, "invalid pwd test passed");
			}
			else if(mbnoc.equalsIgnoreCase("valid") && pwdc.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
			{
				et.log(LogStatus.PASS, "login test passed");
			}
			else
			{
				SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		    	 Date d=new Date();
		    	 String fname=sf.format(d)+".png";
		    	 File src=driver.getScreenshotAs(OutputType.FILE);
		    	 File dest=new File(fname);
		    	 FileHandler.copy(src, dest);
		    	 et.log(LogStatus.FAIL, "way2sms login test failed"+et.addScreenCapture(fname));
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
