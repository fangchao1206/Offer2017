package fang.Thread.管道流;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by fangchao05 on 2017/7/24.
 */
public class ReadThread extends Thread {
    private  ReadData read;
    private PipedInputStream pi;

    public ReadThread(ReadData read, PipedInputStream pi) {
        this.read = read;
        this.pi = pi;
    }

    @Override
    public void run() {
        read.readMethod(pi);
    }


}
