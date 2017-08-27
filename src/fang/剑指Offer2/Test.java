package fang.剑指Offer2;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((  s=bufferedReader.readLine())!=null){
            System.out.println(s);
        }
        int a[]=new int[]{};
       // System.out.println(a[0]);数组越界
        final List list=new ArrayList();
        list.add(1);
        System.out.println(list);
        list.add(2);
        System.out.println(list);

        final List<List<Integer> > resdata = new ArrayList<>();
        resdata.add(list);
        resdata.add(list);
        System.out.println(resdata);
    }
}
