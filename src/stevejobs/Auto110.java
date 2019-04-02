package stevejobs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class Auto110 
{
	public static void main(String[] args) throws Exception 
	{
		//open text file for data reading
		File f1=new File("w2smstestdata.txt");
		FileReader fr=new FileReader(f1);
		BufferedReader br=new BufferedReader(fr);
		//open another file for results writing
		File f2=new File("w2smstestres.txt");
		FileWriter fw=new FileWriter(f2);
		BufferedWriter bw=new BufferedWriter(fw);
		//data driven testing
		String l="";
		while((l=br.readLine())!=null)
		{
			String[] p=l.split(",");
			//launch site
			System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://www.way2sms.com");
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
			driver.manage().window().maximize();
			//do login
			driver.findElement(By.name("mobileNo")).sendKeys(p[0]);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			driver.findElement(By.name("password")).sendKeys(p[2]);
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),' Login ')]")));
			driver.findElement(By.xpath("//*[contains(text(),' Login ')]")).click();
			Thread.sleep(5000);
			//validations
			try
			{
				if(p[0].length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				{
					bw.write("blank mbno test passed");
					bw.newLine();
				}
				else if(p[0].length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
				{
					bw.write("wrong size mbno test passed");
					bw.newLine();
				}
				else if(p[2].length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[2]")).isDisplayed())
				{
					bw.write("blank pwd test passed");
					bw.newLine();
				}
				else if(p[1].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),' not register ')])[1]")).isDisplayed())
				{
					bw.write("invalid mbno test passed");
					bw.newLine();
				}
				else if(p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
				{
					bw.write("invalid pwd test passed");
					bw.newLine();
				}
				else if(p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
				{
					bw.write("login test passed");
					bw.newLine();
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			    	 Date d=new Date();
			    	 String fname=sf.format(d)+".png";
			    	 File src=driver.getScreenshotAs(OutputType.FILE);
			    	 File dest=new File(fname);
			    	 FileHandler.copy(src, dest);
			    	 bw.write( "way2sms login test failed"+fname);
			    	 bw.newLine();
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			//close site
			driver.close();
		}//while ending
			//save results
			br.close();
			fr.close();
			bw.close();
			fw.close();
			
			
			
		}

	}


