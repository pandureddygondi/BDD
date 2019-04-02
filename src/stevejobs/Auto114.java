package stevejobs;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.relevantcodes.extentreports.LogStatus;

public class Auto114 
{
	public static void main(String[] args) throws Exception
	{
		//open file for reading
		PdfReader pr=new PdfReader("mypdf.pdf");
		String ttext=PdfTextExtractor.getTextFromPage(pr, 1);  // 1 means first page in pdf
		String[] lines=ttext.split("\n");
		//open other pdf file for results
		File f=new File("myres.pdf");
		FileOutputStream fo=new FileOutputStream(f);
		//take that file as a pdf file
		Document doc=new Document();
		PdfWriter pw=PdfWriter.getInstance(doc, fo);
		doc.open();
		for(int i=0;i<lines.length;i++)
		{
			String[] p=lines[i].split(",");
			//launch site
			System.setProperty("webdriver.chrome.driver", "E:\\batch242\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://www.gmail.com");
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
			driver.manage().window().maximize();
			driver.findElement(By.name("identifier")).sendKeys(p[0]);
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			Thread.sleep(5000);
			// validations for user-id
			try
			{
				if(p[0].length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Enter an email ')]")).isDisplayed())
				{
					String res1= "gmail blank userid test passed";
					Paragraph p1=new Paragraph(res1);
					doc.add(p1);
				}
				else if(p[1].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'find your Google Account')])[2]")).isDisplayed())
				{
					String res2= "invalid userid test passed";
					Paragraph p2=new Paragraph(res2);
					doc.add(p2);
				}
				else if(p[1].equalsIgnoreCase("valid") && driver.findElement(By.name("password")).isDisplayed())
				{
					String res3= "valid userid test passed";
					Paragraph p3=new Paragraph(res3);
					doc.add(p3);
			    }
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			    	 Date d=new Date();
			    	 String fname=sf.format(d)+".png";
			    	 File src=driver.getScreenshotAs(OutputType.FILE);
			    	 File dest=new File(fname);
			    	 FileHandler.copy(src, dest);
			    	 //put message
			    	 String res4="login test failed";
			    	 Paragraph p4=new Paragraph(res4);
			    	 doc.add(p4);
			    	 //put screenshot image
			    	 Image img=Image.getInstance(fname);
			    	 doc.add(img);
				}
		}
			catch(Exception ex)
			{
				String res5=ex.getMessage();
				Paragraph p5=new Paragraph(res5);
				doc.add(p5);
			}
			//close site
			driver.close();

	  }// close for loop
		//save and close
		doc.close();

   }
}
