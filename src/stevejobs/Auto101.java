package stevejobs;

import java.util.Scanner;

public class Auto101
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String x=sc.nextLine();
		String y="";
		//reverse string using reverse for loop
		for(int i=x.length()-1;i>=0;i--)
		{
			char c=x.charAt(i);
			y=y+c;
		}
		System.out.println(y);
		//check for palindrome
		if(x.equalsIgnoreCase(y))
		{
			System.out.println("palindrome");
		}
		else
		{
			System.out.println("not palindrome");
		}

	}

}
