package fang.Thread.suspend;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fangchao05 on 2017/7/26.
 */
public class Mythread extends Thread {
    @Override
    public void run() {
        int i=0;
       while(true){
           System.out.println(i++);
           AtomicInteger atomicInteger;
       }

        /**
         * println 是同步的方法
         */
        //        public void println(int x) {
//            synchronized (this) {
//                print(x);
//                newLine();
//            }
//        }
    }
}
