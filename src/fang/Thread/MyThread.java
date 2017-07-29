package fang.Thread;

import org.omg.Messaging.SyncScopeHelper;

public class MyThread extends Thread {
	int  count =50;
public static void main(String[] args) {
	MyThread myThread=new MyThread();
	 Thread a=new Thread (myThread,"A");
	 Thread b=new Thread (myThread,"B");
	 Thread c=new Thread (myThread,"C");
	 Thread d=new Thread (myThread,"D");
	 a.start();
	 b.start();
	 c.start();
	 d.start();
}

@Override
 public void run() {
	String a = "" ;
	synchronized(a){
		 
 
			count --;
		System.out.println("由"+this.currentThread().getName()+"计算，count="+count);
		 
		 
		
	}
	
} 

}
