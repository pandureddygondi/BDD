package stevejobs;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Auto63 {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter word");
		String x=sc.nextLine();
		//convert into given voice
		Thread.sleep(5000);
		System.setProperty("mbrola.base", "E:\\batch242\\mbr301d");
		VoiceManager vm=VoiceManager.getInstance();
		Voice v=vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		v.deallocate();
		
	}

}
