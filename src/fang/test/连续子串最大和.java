package fang.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 连续子串最大和 {


    public static int findMaxSum( List <Integer>list) {
        int n = list.size();
        int max=list.get(0);
        int sum[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || sum[i - 1] <= 0) {
                sum[i] = list.get(i);
            } else if (i != 0 && sum[i - 1] > 0) {
                sum[i] = sum[i - 1] + list.get(i);
            }
            if (sum[i] > max) {
                max = sum[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List <Integer>list=new ArrayList();


        while (in.hasNext()){
            String s=in.next();
            list.add(Integer.parseInt(s));
        }
        System.out.println(findMaxSum(list));
    }
}
