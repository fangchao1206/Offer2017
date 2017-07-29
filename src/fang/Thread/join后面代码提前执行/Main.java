package fang.Thread.join后面代码提前执行;

/**
 * Created by fangchao05 on 2017/7/24.
 */
public class Main {
    public static void main(String[] args) {
        try {


            ThreadB b=new ThreadB(); ThreadA a=new ThreadA(b);
/**
 * 下面的三句话 锁对象都是b  所以会同步执行
 */

            b.start();
            b.join(2000);//可以理解为主线程wait，最多等待millis时间  若b执行完了 millis还没到 也直接唤醒
            a.start();System.out.println("Main   end:"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
