package stevejobs;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auto68 {

	public static void main(String[] args) throws Exception
	{
		//launch site
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://gmail.com");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.manage().window().maximize();
		//do login
		driver.findElement(By.name("identifier")).sendKeys("pandureddy211");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		
		driver.findElement(By.name("password")).sendKeys("9492375037");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Compose']")));
		
		//click compose and fill fields
		try
		{
		driver.findElement(By.xpath("//*[@class='bBf']")).click();
		}
		catch(Exception ex)
		{
		}
		driver.findElement(By.xpath("//*[text()='Compose']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
		driver.findElement(By.name("to")).sendKeys("pranaygondi212@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("wishes");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("hai frnd,belated happy new year ");
		driver.findElement(By.xpath("//*[@data-tooltip='Attach files']/descendant::*[3]")).click();
		//handle file upload window(java robot)
		Thread.sleep(5000);
		StringSelection x=new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\tulips");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		//wait until completion of file upload
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='a1 aaA aMZ aF2']")));
		driver.findElement(By.xpath("//*[text()='Send']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Message sent')]")));
		
		
		//do logout
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign out")));
		
		driver.findElement(By.linkText("Sign out")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		
	}

}
