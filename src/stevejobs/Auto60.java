package stevejobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Auto60 
{

	public static void main(String[] args) 
	{
		DesiredCapabilities dc=DesiredCapabilities.chrome();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(dc);
		driver.get("https://www.Angularjs.org");
	}

}
