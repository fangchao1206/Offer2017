package fang.Thread.Lock.ReadWriteLock;

import java.util.Random;

/**不用读写锁 而是用synchroned来实现
 * Created by fangchao05 on 2017/7/26.
 */
public class NoReadWriteTest {

        public static void main(String[] args) {
            final Data1 data = new Data1();
            for (int i = 0; i < 3; i++) {
                new Thread(new Runnable() {
                    public void run() {
                        for (int j = 0; j < 5; j++) {
                            data.set(new Random().nextInt(30));
                        }
                    }
                }).start();
            }
            for (int i = 0; i < 3; i++) {
                new Thread(new Runnable() {
                    public void run() {
                        for (int j = 0; j < 5; j++) {
                            data.get();
                        }
                    }
                }).start();
            }
        }
    }
    class Data {
        private int data;// 共享数据
        public synchronized void set(int data) {
            System.out.println(Thread.currentThread().getName() + "准备写入数据");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "写入" + this.data);
        }
        public synchronized void get() {
            System.out.println(Thread.currentThread().getName() + "准备读取数据");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "读取" + this.data);
        }

}
