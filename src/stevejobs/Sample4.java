package stevejobs;
public class Sample4 
{
	//properties
		public int x;
	    public float y;
	    public char z;
	    public boolean w;
	    public String s;
	    //constructor method
	    public Sample4(int a,char b)
	    {
	    	x=a;
	        z=b;
	        
	    }
	    public Sample4(int a,String d)
	    {
	    	x=a;
	        
	        s=d;
	    }
	    public Sample4(char b,boolean c,String d)
	    {
	    	
	        z=b;
	        w=c;
	        s=d;
	    }
	    //operational methods
	        public void display()
	        {
	        	System.out.println(x);
	        	System.out.println(y);
	        	System.out.println(z);
	        	System.out.println(w);
	        	System.out.println(s);
	        	
	        }
	

}
