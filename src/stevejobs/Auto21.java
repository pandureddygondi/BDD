package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto21 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.goindigo.in");
        driver.manage().window().maximize();
		Thread.sleep(5000);
		//validation
		WebElement e=driver.findElement(By.xpath("(//*[@name='tripTabs'])[1]"));
		if(e.isDisplayed()) 
		{
		if(e.isEnabled()) 
		{
			if(e.isSelected()) {
				System.out.println("oneway is displayed,enabled and selected");
			}
			else {
				System.out.println("oneway is displyed, enabled but not selected");
			}
			}
		else {
			System.out.println("oneway is displayed but not enabled");
		}
		
		}
		else {
			System.out.println("oneway is not displayed");
		}
driver.close();
	}

}
