package stevejobs;

import java.util.ArrayList;
import java.util.Scanner;

public class Auto107 {

	public static void main(String[] args) {
		//declare dynamic array
	ArrayList<Integer>x=new ArrayList<Integer>();
	//get size and random numbers from keyboard
	Scanner sc=new Scanner(System.in);
	System.out.println("enter array size");
	int n=sc.nextInt();
	System.out.println("enter"+n+"random numbers");
	for(int i=0;i<n;i++)
	{
		x.add(sc.nextInt());
	}
	//sorting
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n-1;j++)
		{
			if(x.get(j)>x.get(j+1))
			{
				int temp=x.get(j);
				x.set(j, x.get(j+1));
				x.set(j+1, temp);
			}
		}
	}
	//display and sorted array
	for(int i=0;i<n;i++)
	{
		System.out.print(x.get(i)+" ");
	}

	}

}
