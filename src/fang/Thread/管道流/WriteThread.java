package fang.Thread.管道流;

import java.io.PipedOutputStream;

/**
 * Created by fangchao05 on 2017/7/24.
 */
public class WriteThread extends Thread {
    private WriteData write;
    private PipedOutputStream po;

    public WriteThread(WriteData write, PipedOutputStream po) {
        this.write = write;
        this.po = po;

    }

    @Override
    public void run() {
        write.writeMethod(po);
    }


}
