class College implements Runnable
{
	final String cname="Thangavelu Engineering College";
	final int cid=3126;
	int noofstud=65;
	int sadmi=50;
	int seat;
	College(int seat)
	{
		this.seat=seat;
	}
	public void run()
	{
		synchronized (this)
		{
			String name=Thread.currentThread().getName();
			if(sadmi<=noofstud)
			{
				System.out.println(name + " Got a Admission " + cname + " with "+cid);
				sadmi++;
				try
				{
					Thread.sleep(3500);
				}
				catch(InterruptedException ie){}
			}
			else
			{
				System.out.println(cname+" with "+cid+" Admission is full");
			}
		}
	}
}
class MainCollege
{
	public static void main(String...args)
	{
		College e =new College(3);
		Thread t1= new Thread(e);
		Thread t2= new Thread(e);
		Thread t3= new Thread(e);
		Thread t4= new Thread(e);
		t1.setName("Santhosh");
		t2.setName("Harish");
		t3.setName("Sathish");
		t4.setName("Somesh");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}