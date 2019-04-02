package stevejobs;

import java.util.Scanner;

public class Auto100 
{
	public static void main(String[] args) 
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a limit");
	int l=sc.nextInt();
	int x=0;
	int y=1;
	int z=x+y;
	System.out.println(x+" "+y+"");
    while(z<=l)
      {
	   System.out.println(z+"");
	   x=y;
	   y=z;
	   z=x+y;
      }
	}

}
