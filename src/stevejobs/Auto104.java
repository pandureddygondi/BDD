package stevejobs;

import java.util.Scanner;

public class Auto104 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String x=sc.nextLine();
		int nod=0;
		int nolc=0;
		int nouc=0;
		int nosc=0;
		for(int i=0;i<x.length();i++)
		{
			char c=x.charAt(i);
			if(c>=48 && c<=57)
			{
				nod=nod+1;				
			}
			else if(c>=65 && c<=90)
			{
				nouc=nouc+1;
			}
			else if(c>=97 && c<=122)
			{
				nolc=nolc+1;
			}
			else
			{
				nosc=nosc+1;
			}
		}
		System.out.println("no of digits :" + nod);
		System.out.println("no of lowercase alphabet :" + nolc);
		System.out.println("no of uppercase alphabet :" + nouc);
		System.out.println("no of special charactes :" + nosc);

	}

}
