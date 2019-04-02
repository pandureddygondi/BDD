package stevejobs;
public class Sample15 
{
  public int x;
  public int y;
  public int add()
  {
	  x=10;
	  y=20;
	  int z;
	  z=x+y;
	  return(z);
  }
  public int add(int a)
  {
	  x=a;
	  y=20;
	  int z;
	  z=x+y;
	  return(z);
  }
  public int add(int a,float b)
  {
	  x=a;
	  y=(int)b;
	  int z;
	  z=x+y;
	  return(z);
  }
}
