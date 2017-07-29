package fang.Thread.Lock.测试1;

public class ThreadB extends Thread {
    private Myservice myservice;

    public ThreadB(Myservice myservice) {

        this.myservice = myservice;
    }

    @Override
    public void run() {

        myservice.testMethod();
    }
}
