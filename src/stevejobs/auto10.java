package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class auto10 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		//get x & y coordinates and width & height
		WebElement e=driver.findElement(By.linkText("Gmail"));
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		System.out.println(x +" "+y);
		int j=e.getSize().getWidth();
		int k=e.getSize().getHeight();
		System.out.println(j +" "+k);
		driver.close();
		
		
		
		
	}

}
