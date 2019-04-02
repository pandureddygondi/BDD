package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Auto30 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("iframeResult");
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.name("cars"));
           Select s =new Select(e);
           Actions a=new Actions(driver);
           a.keyDown(Keys.CONTROL).click(s.getOptions().get(0)).click(s.getOptions().get(2)).click(s.getOptions().get(3)).keyUp(Keys.CONTROL).build().perform();
           Thread.sleep(5000);
          // s.deselectAll();
         // List<WebElement> l=s.getAllSelectedOptions();
         // for(int i=0;i<l.size();i++) 
         // {
        //	  System.out.println(l.get(i).getText()); 
         // }
         String x= s.getFirstSelectedOption().getText();
         System.out.println(x);
           Thread.sleep(5000);
           driver.switchTo().defaultContent();
           driver.close();
	}
	

}
