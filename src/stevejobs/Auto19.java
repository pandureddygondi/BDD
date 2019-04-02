package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto19 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
        driver.manage().window().maximize();
		Thread.sleep(5000);
		//validation
		if(driver.findElement(By.name("q")).isDisplayed())
		{
			System.out.println("google site launch test passed");
		}
		else {
			System.out.println("google site launch test failed");
	}
		//close site
driver.close();
}
}