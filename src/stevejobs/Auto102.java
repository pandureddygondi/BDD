package stevejobs;
public class Auto102 
{
	public static void main(String[] args) 
	{
		//example 1
		String x="my name is pandu";
		int y=x.length();
		System.out.println(y);
		
		//example 2
		String k="mindq";
		char j=k.charAt(1);
		System.out.println(j);
		
		//example3
		String z="mindq";
		String kd="mindq";
		if(z.equals(kd))
		{
			System.out.println("same");
		}
		else
		{
			System.out.println("not same");
		}
		
		
		//example4
		String zk="mindq";
		String kk="Mindq";
		if(zk.equalsIgnoreCase(kk))
		{
			System.out.println("same");
		}
		else
		{
			System.out.println("not same");
		}
		
		
		//example 5
		
		String o="mindq is fabulous";
		String p="fabulous";
		if(o.contains(p))
		{
			System.out.println("exists");
		}
		else
		{
			System.out.println("not exists");
		}

	}

}
