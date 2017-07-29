package fang.Thread.ThreadLocal;

/**
 * Created by fangchao05 on 2017/7/25.
 */
public class Thread1 extends   Thread{
    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                System.out.println("在thread1线程中取值="+TestInheritableThread.inheritableThreadLocal.get());
                Thread.sleep(100);
            }
            new Thread(){
                @Override
                public void run() {
                    for(int i=0;i<10;i++){
                        System.out.println("在thread2线程中取值="+TestInheritableThread.inheritableThreadLocal.get());

                    }
                }
            }.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
