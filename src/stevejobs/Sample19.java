package stevejobs;
public class Sample19 extends Sample18
{
     public int x;
     public Sample19(int a)
     {
    	 super(a);
    	 this.x=30;
     }
     public void method()
     {
    	 System.out.println(super.x);
    	 System.out.println(this.x);
     }
}
