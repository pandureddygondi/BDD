package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Alignment;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Auto112 
{
	public static void main(String[] args) throws Exception
	{
		//connect to .xls file
		File f=new File("Book2.xls");
		//open .xls file for reading
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);
		int nour=rsh.getRows(); //count of used rows
		int nouc=rsh.getColumns(); //count of used columns
            //open same .xls file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f, rwb);
		WritableSheet wsh=wwb.getSheet(0);
		//create results column heading(next to last column)
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date d=new Date();
   	    String cname=sf.format(d);
   	    Label l1=new Label(nouc,0,cname);
   	    wsh.addCell(l1);
   	    //data driven from 2nd row(index is 1)
   	    // 1st row(index is 0) have names for columns
   	    for(int i=1;i<nour;i++)
   	    {
   	    	String m=rsh.getCell(0, i).getContents();
   	    	String mc=rsh.getCell(1, i).getContents();
   	    	String p=rsh.getCell(2, i).getContents();
   	    	String pc=rsh.getCell(3, i).getContents();
   	    	//launch site
   	    	System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://www.way2sms.com");
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
			driver.manage().window().maximize();
			//do login
			driver.findElement(By.name("mobileNo")).sendKeys(m);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			driver.findElement(By.name("password")).sendKeys(p);
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),' Login ')]")));
			driver.findElement(By.xpath("//*[contains(text(),' Login ')]")).click();
			Thread.sleep(5000);
			//declarations for results
			WritableFont wf=new WritableFont(WritableFont.TIMES,11,WritableFont.BOLD);
			wf.setColour(Colour.GREEN);
			WritableCellFormat wcf=new WritableCellFormat(wf);
			wcf.setBackground(Colour.YELLOW);
			wcf.setAlignment(Alignment.CENTRE);
			//validations
			try
			{
				if(m.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				{
					Label l2=new Label(nouc,i,"blank mbno test passed",wcf);
					wsh.addCell(l2);
				}
				else if(m.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
				{
					Label l3=new Label(nouc,i,"wrong size mbno test passed",wcf);
					wsh.addCell(l3);
				}
				else if(p.length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[2]")).isDisplayed())
				{
					Label l4=new Label(nouc,i,"blank pwd test passed",wcf);
					wsh.addCell(l4);
				}
				else if(mc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),' not register ')])[1]")).isDisplayed())
				{
					Label l5=new Label(nouc,i,"invalid mbno test passed",wcf);
					wsh.addCell(l5);
				}
				else if(mc.equalsIgnoreCase("valid") && pc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed())
				{
					Label l6=new Label(nouc,i,"invalid pwd test passed",wcf);
					wsh.addCell(l6);
				}
				else if(mc.equalsIgnoreCase("valid") && pc.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
				{
					Label l7=new Label(nouc,i,"login test passed",wcf);
					wsh.addCell(l7);
				}
				else
				{
					wf.setColour(Colour.RED);
			    	 String fname=sf.format(d)+".png";
			    	 File src=driver.getScreenshotAs(OutputType.FILE);
			    	 File dest=new File(fname);
			    	 FileHandler.copy(src, dest);
			    	 Label l8=new Label( nouc,i,"way2sms login test failed"+fname,wcf);
			    	 wsh.addCell(l8);
				}
			}
			catch(Exception ex)
			{
				wf.setColour(Colour.BLACK);
				Label l9=new Label( nouc,i,ex.getMessage(),wcf);
				wsh.addCell(l9);
			}
			//close site
			driver.close();
		}//for loop ending
			//save results
   	        wwb.write();
			wwb.close();
			rwb.close();
			
   	    
	}

}
