package stevejobs;

import java.util.Scanner;

public class Auto89 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter card type");
        String x=sc.nextLine();
        switch(x)
        {
        case "VISA":
        	System.out.println("valid card");
        	break;
        case "MASTER":
        	System.out.println("valid card");
        	break;
        case "RUPAY":
        	System.out.println("valid card");
        	break;
        default:
        	System.out.println("invalid card");
        	break;
        	
        }
	}

}
