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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Sendsmspage;

public class Auto116 
{
   public WebDriver driver;
   public WebDriverWait w;
   public Homepage hp;
   public Sendsmspage sp;
   
   @Test(priority=1)
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
   @Test(priority=2)
   @Parameters({"m","p"})
   public void login(String m, String p) throws Exception 
   {
	   hp.fillmbno(m);
	   w.until(ExpectedConditions.visibilityOf(hp.pwd));
	   hp.fillpwd(p);
	   w.until(ExpectedConditions.elementToBeClickable(hp.loginbtn));
	   hp.clickloginbtn();
	   Thread.sleep(5000);
   }
   @Test(priority=3)
   @Parameters({"m","mc","p","pc"}) 
   public void validations(String m, String mc, String p,String pc) throws Exception
   {
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
   @Test(priority=4)
   public void closesite()
   {
	   driver.close();
   }
}
