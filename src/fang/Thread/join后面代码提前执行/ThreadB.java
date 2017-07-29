package fang.Thread.join后面代码提前执行;

/**
 * Created by fangchao05 on 2017/7/24.
 */
public class ThreadB extends Thread {

    @Override
   synchronized public void run() {
        try {
            System.out.println("B "+"begin at:"+System.currentTimeMillis());

            Thread.sleep(5000);
            System.out.println("B "+"end   at:"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
