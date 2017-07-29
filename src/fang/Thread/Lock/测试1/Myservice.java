package fang.Thread.Lock.测试1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Myservice {
    private Lock lock = new ReentrantLock();

    public void testMethod() {
        try {

            lock.lock();
            System.out.println(Thread.currentThread().getName() + " begin at:" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " end at:" + System.currentTimeMillis());
            lock.unlock();
        } catch (Exception e) {

        }

    }
}
