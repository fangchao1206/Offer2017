package fang.Thread.Lock.测试1;

/**
 * Created by fangchao05 on 2017/7/25.
 */
public class Main {
    public static void main(String[] args) {
        Myservice myservice=new Myservice();
        Myservice myservice1=new Myservice();
        Myservice myservice2=new Myservice();
        ThreadA t1=new ThreadA(myservice);
        ThreadA t2=new ThreadA(myservice);
        ThreadA t3=new ThreadA(myservice);
        ThreadA t4=new ThreadA(myservice);
        ThreadA t5=new ThreadA(myservice);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
