package stevejobs;

import java.util.Scanner;

public class Auto92 
{
	public static void main(String[] args) 
	{ 
		//get limit from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a limit");
		int l=sc.nextInt();
		//get all prime numbers below limit
		for(int j=1;j<=l;j++)
		{
			int flag=0;
			//check for prime
			for(int i=2;i<j;i++)
			{
				if(j%i==0)
				{
					flag=1;
				}
			}
			if(flag==0)
			{
				System.out.println(j);
			}
		}
		

	}

}
