package stevejobs;

import java.util.Scanner;

public class Auto106 
{
	public static void main(String[] args) 
	{
		//take 5 numbers array
		int[] x=new int[5];
		Scanner sc=new Scanner(System.in);
		System.out.println("enter 5 andom numbers");
		for(int i=0;i<5;i++)
		{
			x[i]=sc.nextInt();
		}
		//sorting
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(x[j]>x[j+1])
				{
					int temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
				}
			}
		}
		//display sorted array
		for(int i=0;i<5;i++)
		{
			System.out.print(x[i]+"  ");
		}
			

	}

}
