package fang.Thread.Lock.FutureAndRunable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by fangchao05 on 2017/7/25.
 */
public class RunnableAndFutureTask {
    public static void main(String[] args) {
       Runnable runnable=new Runnable() {
           @Override
           public void run() {
               new Random().nextInt(100);
           }
       };
       int  result=15;
        FutureTask<Integer> future = new FutureTask<Integer>(runnable,result);
        new Thread(future).start();
        try {
            Thread.sleep(2000);// 可能做一些事情
            System.out.println(future.get());//2s后输出15
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
