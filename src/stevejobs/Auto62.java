package stevejobs;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Auto62 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter word");
		String x=sc.nextLine();
		//convert into voice
		VoiceManager vm=VoiceManager.getInstance();
		Voice v=vm.getVoice("kevin");
		v.allocate();
		v.speak(x);
		v.deallocate();
		
	}

}
