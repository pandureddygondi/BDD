package stevejobs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Auto22 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "E://batch242//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("//*[@alt='Google']"));
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		int w=e.getSize().getWidth();
		int h=e.getSize().getHeight(); 
		//Take fullscreenshot as image
		File src=driver.getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg=ImageIO.read(src);
		//get element screenshot from full screenshot
		BufferedImage eless=fullImg.getSubimage(x, y, w, h);
		ImageIO.write(eless,"png", src);
		//save element screenshot in hdd
		File dest= new File("E:\\batch242\\ess.png");
		FileHandler.copy(src, dest);
		//driver.close
		driver.close();
	}

}
