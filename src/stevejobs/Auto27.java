package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class Auto27 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		//check drop down	
		WebElement e=driver.findElement(By.name("nights"));
		Select s=new Select(e);
		List<WebElement> l=s.getOptions();
		int n=l.size();
		System.out.println(n);
		for(int i=0;i<n;i++) 
		{
System.out.println(l.get(i).getText());
	    }
		//close site
		driver.close();
	}
}
