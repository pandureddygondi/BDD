package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import pages.Homepage;
import pages.Sendsmspage;

public class Auto118 
{
	public WebDriver driver;
    public WebDriverWait w;
    public Homepage hp;
    public Sendsmspage sp;
    
    @DataProvider(name="testdata")
    public Object[][] method() throws Exception
    {
    	//open excel file for reading
    	File f=new File("w2smstest.xls");
    	Workbook rwb=Workbook.getWorkbook(f);
    	Sheet rsh=rwb.getSheet(0); //0 means first sheet
    	int nour=rsh.getRows();
    	int nouc=rsh.getColumns();
    	//create 2-dimensional array
    	Object[][] data=new Object[nour-1][nouc];
    	//copy data from excel to 2-d array
    	//0th row have names columns
    	for(int i=1;i<nour;i++)
    	{
    		for(int j=0;j<nouc;j++)
    		{
    			data[i-1][j]=rsh.getCell(j, i).getContents();
    		}
    	}
    	//close excel
    	rwb.close();
    	return(data);
    }
    @BeforeMethod
    public void launch()
    {
    	 //open browser
 	   System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
 	   driver=new ChromeDriver();
 	   driver.manage().window().maximize();
 	   //create objects to page classes
 	  hp=new Homepage(driver);
 	  sp=new Sendsmspage(driver);
 	   
 	   //launch site
 	   driver.get("http://www.way2sms.com");
 	   w= new WebDriverWait(driver,20);
 	   w.until(ExpectedConditions.visibilityOf(hp.mbno));
    }
    @Test(dataProvider="testdata")
    public void login(String m,String mc,String p,String pc) throws Exception
    {
       hp.fillmbno(m);
 	   w.until(ExpectedConditions.visibilityOf(hp.pwd));
 	   hp.fillpwd(p);
 	   w.until(ExpectedConditions.elementToBeClickable(hp.loginbtn));
 	   hp.clickloginbtn();
 	   Thread.sleep(5000);
 	   //validations
 	  try
	   {
		   
	   
	   if(m.length()==0 && hp.blankmbno.isDisplayed())
	   {
		   Reporter.log("blank mbno test passed");
		   Assert.assertTrue(true);
	   }
	   else if(m.length()<10 && hp.wrongsizembno.isDisplayed())
	   {
		   Reporter.log("wrongsize mbno test passed");
		   Assert.assertTrue(true);
	   }
	   else if(mc.equalsIgnoreCase("invalid") && pc.equalsIgnoreCase("valid") && hp.invalidmbno.isDisplayed())
	   {
		   Reporter.log("invalid mbno test passed");
		   Assert.assertTrue(true);
	   }
	   else if(p.length()==0 && hp.blankpwd.isDisplayed())
	   {
		   Reporter.log("blank pwd test passed");
		   Assert.assertTrue(true);
	   }
	   else if(mc.equalsIgnoreCase("valid") && pc.equalsIgnoreCase("invalid") && hp.invalidpwd.isDisplayed())
	   {
		   Reporter.log("invalid pwd test passed");
		   Assert.assertTrue(true);
	   }
	   else if(mc.equalsIgnoreCase("valid") && pc.equalsIgnoreCase("valid") && sp.sendsmsmsg.isDisplayed() )
	   {
		   Reporter.log("valid data test passed");
		   Assert.assertTrue(true);
		   // do logout
		   w.until(ExpectedConditions.elementToBeClickable(sp.signout));
		   sp.clicksignout();
	   }
	   else
	   {
		   SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
	    	 Date d=new Date();
	    	 String fname=sf.format(d)+".png";
	    	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	 File dest=new File(fname);
	    	 FileHandler.copy(src, dest);
	    	 Reporter.log("Login test failed");
	    	 String path="E:\\batch242\\w2smstestng\\"+fname;
	    	 String code="<img src=\"file:///"+path+"/\" alt=\"\" />";
	    	 Reporter.log(code);
	    	 Assert.assertTrue(false);
	   }
	 }
	   catch(Exception ex)
	   {
		   Reporter.log(ex.getMessage());
		   Assert.assertTrue(false);
	   }
    }
    @AfterMethod
    public void closesite()
    {
    	driver.close();
    }
    
}
