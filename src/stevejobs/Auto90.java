package stevejobs;

import java.util.Scanner;

public class Auto90 
{
	public static void main(String[] args) 
	{
		//enter a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int x=sc.nextInt();
		int y=0;
		while(x>0)
		{
			int d=x%10;
			y=y*10+d;
			x=(int)(x/10);
		}
		System.out.println("Reverse number is " + y);
		

	}

}
