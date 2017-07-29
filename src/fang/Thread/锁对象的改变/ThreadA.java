package fang.Thread.锁对象的改变;

 
public class ThreadA extends Thread {
private Myservice myservice;
public ThreadA(Myservice myservice) {
	// TODO Auto-generated constructor stub
super();
this.myservice=myservice;
}
@Override
	public void run() {
	try {
		System.out.println("A"+"begin at:"+System.currentTimeMillis());

		Thread.sleep(5000);
		System.out.println("A"+"end   at:"+System.currentTimeMillis());
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}
