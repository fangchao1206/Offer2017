package 真题;

import com.sun.org.apache.regexp.internal.RE;

import java.sql.ResultSet;
import java.util.*;

public class fd {
    public static void main(String[] args) {
        List< Integer> results=new ArrayList();
        results.add(1);
        results.add(2);
        results.add(3);
        results.add(4);
        results.add(5);
        for(int i=0;i<results.size();i++){
            results.remove(i); //不可用 会出现意想不到的结果
        }
        System.out.println(results.size());//2

        int arr[]=new int[5];
        System.out.println(arr[0]);
    }
}
