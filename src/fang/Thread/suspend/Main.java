package fang.Thread.suspend;

/**
 * Created by fangchao05 on 2017/7/26.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Mythread mythread=new Mythread();
            mythread.start();
            Thread.sleep(1000);
            mythread.suspend();
            Thread.sleep(1000);
         System.out.println("main  end");
            System.out.println("main  resume ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
