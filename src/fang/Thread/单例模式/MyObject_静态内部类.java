package fang.Thread.单例模式;

/**
 * 利用静态内部类实现单例模式
 * Created by fangchao05 on 2017/7/28.
 */
public class MyObject_静态内部类 {
    //内部类方式
   private  static class MyObjHandler  {
        private static MyObject_静态内部类 myObject = new MyObject_静态内部类();
    }

   private  MyObject_静态内部类() {
        System.out.println("单例 构造函数");
    }

    public static MyObject_静态内部类 getInstance() {
        return MyObjHandler.myObject;
    }

    public static void main(String[] args) {
        My1Thread t1 = new My1Thread();
        My1Thread t2 = new My1Thread();
        My1Thread t3 = new My1Thread();
        t1.start();
        t2.start();
        t3.start();
    }

}

class My1Thread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject_静态内部类.getInstance().hashCode());
    }
}



