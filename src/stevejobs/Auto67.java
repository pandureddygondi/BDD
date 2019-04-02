package stevejobs;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class Auto67
{

	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter input1");
		String x=sc.nextLine();
		System.out.println("enter input2");
		String y=sc.nextLine();
		//launch calculator window
		Runtime.getRuntime().exec("c:\\windows\\system32\\calc.exe");
		Thread.sleep(5000);
		//send input1 to calculator
		StringSelection s1=new StringSelection(x);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//click +
		r.keyPress(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_ADD);
		//send input2
		StringSelection s2=new StringSelection(y);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s2, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//click on 
		r.keyPress(KeyEvent.VK_EQUALS);
		r.keyRelease(KeyEvent.VK_EQUALS);
		Thread.sleep(5000);
		//get output from calculator
		r.keyPress(KeyEvent.VK_CONTEXT_MENU);
		r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		String z=(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		System.out.println(z);
		//close calculator
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_ALT);
		
		
		
		
		
		
	}

}
