package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test300 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		driver.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CSS")));
		WebElement e1=driver.findElement(By.linkText("CSS"));
		String x=e1.getAttribute("title");
		System.out.println(x);
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Bottom')]")));
		WebElement e2=driver.findElement(By.xpath("//div[contains(text(),'Bottom')]"));
		Actions a=new Actions(driver);
		a.moveToElement(e2).build().perform();
		WebElement e3=driver.findElement(By.xpath("//*[@class='tooltiptext tooltip-bottom']"));
		String y=e3.getText();
		System.out.println(y);
		driver.close();
		
		

	}

}
