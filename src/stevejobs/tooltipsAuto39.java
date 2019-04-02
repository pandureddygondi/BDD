package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class tooltipsAuto39 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement e=driver.findElement(By.linkText("JAVASCRIPT"));
		String x=e.getAttribute("title");
		System.out.println(x);
		//get tooltip of an element
		//here tooltips is child element to element
		WebElement e2=driver.findElement(By.xpath("//div[@class='tooltip'][contains(text(),'Bottom')]"));
		Actions a=new Actions(driver);
		a.moveToElement(e2).build().perform();
		WebElement e3=driver.findElement(By.xpath("//*[@class='tooltiptext tooltip-bottom']"));
		a.clickAndHold(e3).build().perform();
		String y=e3.getText();
		System.out.println(y);
		a.release().build().perform();
		//close site
		driver.close();
		

	}

}
