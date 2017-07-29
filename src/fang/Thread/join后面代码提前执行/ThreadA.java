package fang.Thread.join后面代码提前执行;

/**
 * Created by fangchao05 on 2017/7/24.
 */
public class ThreadA extends Thread {

    private ThreadB b;
    public ThreadA(ThreadB b) {


        this.b=b;
    }
    @Override
     public void run() {

        try {

          synchronized (b) {
                System.out.println("A "+"begin at:"+System.currentTimeMillis());

                Thread.sleep(5000);
                System.out.println("A "+"end   at:"+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
