package fang.Thread.管道流;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by fangchao05 on 2017/7/24.
 */
public class ReadData {
    public void readMethod(PipedInputStream in)  {
        try {
            System.out.println("read:");
            byte[] ba = new byte[50];
            int len ;
            while ((len=in.read(ba))!=-1) {
                String s=new String(ba, 0, len);
                System.out.println(s);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
