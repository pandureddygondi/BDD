package stevejobs;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Auto77 
{
     public static void main(String[] args) throws Exception
     {
		ExtentReports er=new ExtentReports("googleres.html",false);
		ExtentTest et=er.startTest("google title testing");
		//launch site
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://google.co.in");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		
		driver.manage().window().maximize();
		//get title
		String t=driver.getTitle();
		//validation
		if(t.equals("Google"))
		{
			String fname=screenshot(driver);
			et.log(LogStatus.PASS, "Google title test passed"+et.addScreenCapture(fname));
		}
		else
		{
			String fname=screenshot(driver);
			et.log(LogStatus.FAIL, "Google title test failed"+et.addScreenCapture(fname));
		}
		//close site
		driver.close();
		//save changes in html file
		er.endTest(et);
		er.flush();
	}
     public static String screenshot(ChromeDriver driver) throws Exception
     {
    	 SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
    	 Date d=new Date();
    	 String fname=sf.format(d)+".png";
    	 File src=driver.getScreenshotAs(OutputType.FILE);
    	 File dest=new File(fname);
    	 FileHandler.copy(src, dest);
    	 return(fname);
     }

}
