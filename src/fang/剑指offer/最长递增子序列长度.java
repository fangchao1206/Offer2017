package fang.剑指offer;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 用动态规划的方法
 * Created by fangchao05 on 2017/8/11.
 * http://www.cnblogs.com/liyukuneed/archive/2013/05/26/3090402.html
 */
public class 最长递增子序列长度 {
    /**
     * 0(n*n)
     * @param s
     * @return
     */
    public static int getLongestSubSeq(int s[]) {
        int n = s.length;
        int d[] = new int[n];
        int max = d[0];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {//小于 第一层循环的那个i

                if (s[j] <= s[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }

            }
            if (d[i] > max) {
                max = d[i];
            }


        }
        for(int m:d){
            System.out.println(m);
        }
        return max;
    }

    public static void main(String[] args) {
        int A[] = {
                8,9,10,1,2,8,10,5
        };

        System.out.println("max="+getLongestSubSeq(A));
    }
}
