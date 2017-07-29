package fang.Thread.锁对象的改变;

public class TestRun {

    public static void main(String[] args) throws InterruptedException {
        Myservice myservice = new Myservice();
        ThreadA a = new ThreadA(myservice);
        ThreadB b = new ThreadB(myservice);
        a.setName("A");
        b.setName("b");
        a.start();
        Thread.sleep(1000);// 设成1 结果会不一样
        b.start();
    }

}
