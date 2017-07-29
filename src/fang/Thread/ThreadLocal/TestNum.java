package fang.Thread.ThreadLocal;

/**
 * Created by fangchao05 on 2017/7/25.
 */
public class TestNum {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static int getNextNum() {
        threadLocal.set(threadLocal.get() + 1);
        return threadLocal.get();
    }

    static class MyThread extends Thread {
        private TestNum testNum;

        public MyThread(TestNum testNum) {
            this.testNum = testNum;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                //  每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> NUM["
                        + testNum.getNextNum() + "]");

            }
        }
    }

    public static void main(String[] args) {
        TestNum tnm = new TestNum();
        MyThread thread1 = new MyThread(tnm);
        MyThread thread2 = new MyThread(tnm);
        MyThread thread3 = new MyThread(tnm);
        MyThread thread4 = new MyThread(tnm);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
