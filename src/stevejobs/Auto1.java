package stevejobs;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Auto1 {

	private static final String LogOut = null;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(co);
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("pandureddy211@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("pandu143");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@aria-label='Log In']")).click();
		Thread.sleep(5000);
		try
		{
			
		 
		     if(driver.findElement(By.xpath("//*[contains(@id,'notificationsCountValue')]")).isEnabled())
		     {
			   driver.findElement(By.xpath("//*[contains(@id,'notificationsCountValue')]")).click();
			   Thread.sleep(5000);
		     }
		
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		
	
		driver.findElement(By.xpath("//*[@aria-labelledby='userNavigationLabel']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		Thread.sleep(5000);
		driver.close();
		
	}
}
