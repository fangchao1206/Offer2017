package fang.Thread.管道流;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created by fangchao05 on 2017/7/24.
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out)   {
        try {
            System.out.println("write:");
            for(int i=0;i<100;i++){
                String data=i+1+"";
                out.write(data.getBytes());
                System.out.println(data);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
