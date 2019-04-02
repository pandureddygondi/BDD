package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class auto12 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "E:\\batch242\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://www.amazon.in");
Thread.sleep(5000);
//get count of all elements in a page
List<WebElement>l=driver.findElements(By.xpath("//*"));

System.out.println(l.size());
//get count of  links in a page
List<WebElement>k=driver.findElements(By.xpath("//a"));

System.out.println(k.size());
//get count of tables in a page
List<WebElement>j=driver.findElements(By.xpath("//table"));

System.out.println(j.size());
//get count of rows in a page
List<WebElement>i=driver.findElements(By.xpath("//tr"));

System.out.println(i.size());
//get count of coloms in a page
List<WebElement>h=driver.findElements(By.xpath("//td"));

System.out.println(h.size());
//get count of bootstrap in a page
List<WebElement>g=driver.findElements(By.xpath("//div"));

System.out.println(g.size());
//get count of textboxes in a page
List<WebElement>f=driver.findElements(By.xpath("//input[@type='text']"));

System.out.println(f.size());
driver.close();

	}

}
