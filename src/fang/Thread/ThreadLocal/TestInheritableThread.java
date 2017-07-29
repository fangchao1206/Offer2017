package fang.Thread.ThreadLocal;

import java.util.Date;

/**
 * Created by fangchao05 on 2017/7/25.
 */
public class TestInheritableThread {
    static  InheritableThreadLocal inheritableThreadLocal=new InheritableThreadLocal(){
        @Override
        protected Object initialValue() {
            return  new Date().toLocaleString();
        }


        protected Object childValue(Object parentValue) {
            return parentValue+"   子类加的！";
        }

    };


    public static void main(String[] args) {
        try {
            for(int i=0;i<10;i++){
                System.out.println("Main 中取值==="+inheritableThreadLocal.get());
                Thread.sleep(100);
            }
            Thread.sleep(2000);
            Thread1 thread1=new Thread1();
            thread1.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
