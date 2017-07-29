package fang.Thread.单例模式;

/**
 * 懒汉模式/延迟加载
 * 当然懒汉式也是可以实现线程安全的，只要加上synchronized即可，如下：
 * public static synchronized Singleton getInstance(){}
 * 但是这样一来，会降低整个访问的速度，而且每次都要判断，所以我们只锁部分代码，而且只有在obj不存在的时候
 * 才新建、
 * 引入DCL双检验锁机制
 * <p>
 * Created by fangchao05 on 2017/7/28.
 */

/**
 * 使用DCL既保证了不需要同步的代码的异步性 又保持了单例的效果
 */
public class MyObject_懒汉模式 {
    private volatile static MyObject_懒汉模式 myObject;//注意这个应该是 volatitle的

    private MyObject_懒汉模式() {

    }

    public static MyObject_懒汉模式 getInstance() {
        try {
            if (myObject != null) {

            } else {
                Thread.sleep(500);//模拟在对象创建前的一些工作
                synchronized(MyObject_懒汉模式.class) {
                    if (myObject == null) {//双重检验  防止两个过了第一重检验后又分别创建多个对象
                        myObject = new MyObject_懒汉模式();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println(MyObj_饿汉模式.getInstance().hashCode());
    }
}

class Test1 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        MyThread1 t3 = new MyThread1();
        MyThread1 t4 = new MyThread1();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

