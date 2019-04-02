package stevejobs;

import org.openqa.selenium.ie.InternetExplorerDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.opera.OperaOptions;

public class Text1 {

	public static void main(String[] args) {
		/*System.setProperty("webdriver.gecko.driver", "E:\\batch242\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://google.co.in");*/
		
		//code to work with opera driver
		
		/*OperaOptions ff=new OperaOptions();
		ff.setBinary("C:\\Users\\Dell\\AppData\\Local\\Programs\\Opera\\launcher.exe");
		System.setProperty("webdriver.opera.driver", "E:\\batch242\\operadriver_win64\\operadriver_win64\\operadriver.exe");
		OperaDriver driver=new OperaDriver(ff);
		driver.get("http://facebook.com");
*/
		System.setProperty("webdriver.ie.driver","E:\\batch242\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		InternetExplorerDriver driver=new InternetExplorerDriver();
		driver.get("http://www.facebook.com");
	
	}
}
