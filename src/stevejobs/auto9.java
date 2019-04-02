package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class auto9 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		//get colour before focus
		WebElement x=driver.findElement(By.linkText("Gmail"));
		String k=x.getCssValue("color");
		String j=x.getCssValue("text-decoration");
		System.out.println(k+" "+j);
		//send mouse focus to element
		Actions a=new Actions(driver);
		a.moveToElement(x).build().perform();
		//get colour after focus
		String b=x.getCssValue("opacity");
		String c=x.getCssValue("text-decoration");
		System.out.println(b+" "+c);
		driver.close();
		
	}

}
