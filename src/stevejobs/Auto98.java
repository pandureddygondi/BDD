package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Auto98 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter userid");
		String uid=sc.nextLine();
		System.out.println("enter password");
		String pwd=sc.nextLine();
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
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
				driver.findElement(By.name("password")).sendKeys(pwd);
				w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(5000);
				//count no of unread mails
				int count=0;
				while(2>1)
				{
					List<WebElement>mails=driver.findElements(By.xpath("(//table)[4]/tbody/tr"));
					for(int i=0;i<mails.size();i++)
					{
						WebElement e=driver.findElement(By.xpath("(//table)[4]/tbody/tr["+(i+1)+"]/td[5]/div[1]"));
						driver.executeScript("var k=arguments[0].textContent;window.alert(k);", e);
						String t=driver.switchTo().alert().getText();
						driver.switchTo().alert().dismiss();
						if(t.contains("unread"))
						{
							count++;
						}
					}
					try
					{
						if(driver.findElement(By.xpath("//*[@data-tooltip='Older']")).getAttribute("aria-disabled").equals("true"))
						{
							break;
						}
					}
					catch(Exception ex)
					{
						driver.findElement(By.xpath("//*[@data-tooltip='Older']")).click();
						Thread.sleep(5000);
					}
				}
				String temp=driver.findElement(By.xpath("//*[@data-tooltip='Inbox']/div/div/div")).getText();
				temp.replace(",", "");
				int c=Integer.parseInt(temp);
				if(c==count)
				{
					et.log(LogStatus.PASS, "unreadmails count test passed");
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			    	 Date d=new Date();
			    	 String fname=sf.format(d)+".png";
			    	 File src=driver.getScreenshotAs(OutputType.FILE);
			    	 File dest=new File(fname);
			    	 FileHandler.copy(src, dest);
					et.log(LogStatus.FAIL, "unread mail count test failed"+et.addScreenCapture(fname));
				}
				//logout
				driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span ")).click();
				w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Sign out']")));
				driver.findElement(By.xpath("//*[text()='Sign out']")).click();
				//close site
				driver.close();
				//save results
				er.endTest(et);
				er.flush();

	}

}
