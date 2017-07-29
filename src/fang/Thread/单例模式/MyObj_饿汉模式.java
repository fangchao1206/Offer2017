package fang.Thread.单例模式;

/**
 * 饿汉模式/立即加载模式  是在调用方法前 实例已经被创建了
 * 饿汉式是线程安全的，因为虚拟机保证只会装载一次，在装载类的时候是不会发生并发的
 * Created by fangchao05 on 2017/7/28.
 */
public class MyObj_饿汉模式 {
    private static MyObj_饿汉模式 obj = new MyObj_饿汉模式();

    private MyObj_饿汉模式() {

    }

    public static MyObj_饿汉模式 getInstance() {
        return obj;
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObj_饿汉模式.getInstance().hashCode());
    }
}

class Test {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();

    }
}
