package fang.Thread.锁对象的改变;

 
public class ThreadB extends Thread {
private Myservice myservice;
public ThreadB(Myservice myservice) {
	// TODO Auto-generated constructor stub
super();
this.myservice=myservice;
}
@Override
	public void run() {
		// TODO Auto-generated method stub
		myservice.testMethod();
	}
}
