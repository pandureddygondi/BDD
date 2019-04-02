package stevejobs;

import java.util.Scanner;

public class Auto103 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter main string");
		String x=sc.nextLine();
		System.out.println("enter sub string");
		String y=sc.nextLine();
		int noo=0;
		String[] p=x.split("");
		for(int i=0; i<p.length;i++) 
		{
			if(p[i].equalsIgnoreCase(y))
			{
				noo=noo+1;
			}
		}
		System.out.println(noo);

	}

}
