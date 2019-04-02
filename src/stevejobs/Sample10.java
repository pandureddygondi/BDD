package stevejobs;
public class Sample10 
{
  public int x;
  private Sample10() 
  {
	  x=10;
  }
  public static Sample10 createobject()
  {
	  Sample10 obj=new Sample10();
	  return(obj);
  }
  public void display()
  {
	  System.out.println(x);
  }
}
