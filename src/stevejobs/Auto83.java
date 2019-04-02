package stevejobs;

import java.util.Scanner;

public class Auto83 
{
	public static void main(String[] args) 
	{
		//get input from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int x=sc.nextInt();
		//observation/validation
		if(x%2==0)
		{
			System.out.println(x+"is a even number");
		}
		else
		{
			System.out.println(x+"is odd number");
		}

	}

}
