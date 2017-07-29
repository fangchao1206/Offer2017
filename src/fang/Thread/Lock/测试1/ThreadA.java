package fang.Thread.Lock.测试1;

public class ThreadA extends Thread {
    private Myservice myservice;

    public ThreadA(Myservice myservice) {
        this.myservice = myservice;
    }

    @Override
    public void run() {
        myservice.testMethod();
    }
}
