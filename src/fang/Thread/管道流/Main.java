package fang.Thread.管道流;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by fangchao05 on 2017/7/24.
 */
public class Main {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedOutputStream outputStream = new PipedOutputStream();
            PipedInputStream inputStream = new PipedInputStream();
            inputStream.connect(outputStream);

            ReadThread readThread = new ReadThread(readData, inputStream);
            WriteThread writeThread = new WriteThread(writeData, outputStream);

            writeThread.start();
            Thread.sleep(2000);
            readThread.start();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
