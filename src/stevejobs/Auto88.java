package stevejobs;

import java.util.Scanner;

public class Auto88
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter grade");
		String gs=sc.nextLine();
		char gc=gs.charAt(0);
		switch(gc)
		{
		case 'A':
			System.out.println("not in world");
			break;
		case 'B':
			System.out.println("not in india");
			break;
		case 'C':
			System.out.println("not in state");
			break;
		case 'D':
			System.out.println("not in district");
			break;
		default:
			System.out.println("not in school");
			break;
		}

	}

}
