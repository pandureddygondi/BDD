package stevejobs;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto23 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://batch242//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		//maximize
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//get size and change size
        int w=driver.manage().window().getSize().getWidth();
        int h=driver.manage().window().getSize().getHeight();
        System.out.println(w+" "+h);
       
        Dimension d= new Dimension(400,300);
        		driver.manage().window().setSize(d);
        Thread.sleep(5000);
     // get position N chnage position
        int x=driver.manage().window().getPosition().getX();
        int y=driver.manage().window().getPosition().getY();
        System.out.println(x+" "+y);
        Point p=new Point(400,100);
        driver.manage().window().setPosition(p);
        Thread.sleep(5000);
        //driver.close
        driver.close();
	}

}
