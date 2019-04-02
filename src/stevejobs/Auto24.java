package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Auto24 {

	public static void main(String[] args) throws InterruptedException {
		//delete all existing cookies
		System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        //launch site
        driver.get("http://www.google.co.in");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //validate cookies
        if(driver.manage().getCookies().size()!=0) 
        {
        	System.out.println("cookies test passed");
        }
        else 
        {
        	System.out.println("cookies test failed");
        }
        //close site
        driver.close();
	}

}
