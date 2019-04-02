package stevejobs;
public class Sample3 
{
	//properties
	public int x;
    public float y;
    public char z;
    public boolean w;
    public String s;
    //constructor method
    public Sample3(int a,char b,boolean c,String d)
    {
    	x=a;
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
