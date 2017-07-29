package fang.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class CountOperate extends Thread {
    public CountOperate(String s) {
        this.setName(s);
        System.out.println("countOperate  begin---");
        System.out.println("Thread.currentThreat.getName()===" + Thread.currentThread().getName());
        System.out.println("this.getName()====" + this.getName());
        System.out.println("countOperate  end---");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("run --- begin---");
        System.out.println("Thread.currentThreat.getName()===" + Thread.currentThread().getName());
        System.out.println("this.getName()====" + this.getName());
        System.out.println("run----  end---");
    }

    public static void main(String[] args) {
        //	AtomicInteger
        CountOperate c = new CountOperate("cccccc");
        //Thread t1=new Thread(c);//Thread.currentThreat.getName()===Thread-1
        //Thread t1=new Thread(new Thread(c));//Thread.currentThreat.getName()===Thread-2
        Thread t1 = new Thread(new Thread(new Thread(c)));//Thread.currentThreat.getName()===Thread-3
        t1.start();

    }
}
