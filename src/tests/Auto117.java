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

import pages.Homepage;
import pages.Sendsmspage;

public class Auto117 
{
    public WebDriver driver;
    public WebDriverWait w;
    public Homepage hp;
    public Sendsmspage sp;
    @DataProvider(name="testdata")
    public Object[][] method()
    {
    	Object[][] data=new Object[6][4];
    	
    	data[0][0]="9492375037";
    	data[0][1]="valid";
    	data[0][2]="pandu143";
    	data[0][3]="valid";
    	
    	data[1][0]="";
    	data[1][1]="invalid";
    	data[1][2]="pandu143";
    	data[1][3]="valid";
    	
    	data[2][0]="94922";
    	data[2][1]="invalid";
    	data[2][2]="pandu143";
    	data[2][3]="valid";
    	
    	data[3][0]="9492580532";
    	data[3][1]="invalid";
    	data[3][2]="pandu143";
    	data[3][3]="valid";
    	
    	data[4][0]="9492375037";
    	data[4][1]="valid";
    	data[4][2]="";
    	data[4][3]="invalid";
    	
    	data[5][0]="9492375037";
    	data[5][1]="valid";
    	data[5][2]="pand43";
    	data[5][3]="invalid";
    	
    	
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
