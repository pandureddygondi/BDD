package stevejobs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Auto64 {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter word");
		String x=sc.nextLine();
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--use-fake-ui-for-media-stream=1");
		ChromeDriver driver=new ChromeDriver(co);
		//launch google site
         driver.get("https://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,30);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.manage().window().maximize();
		//click on mic icon in google page
		driver.findElement(By.xpath("//*[@class='voice_search_button']/span")).click();
		Thread.sleep(3000);
		//convert into voice
		System.setProperty("mbrola.base", "E:\\batch242\\mbrola");
		VoiceManager vm=VoiceManager.getInstance();
		Voice v=vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		v.deallocate();
		
		
	}

}
