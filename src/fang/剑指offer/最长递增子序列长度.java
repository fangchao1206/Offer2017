package fang.剑指offer;

/**
 * 用动态规划的方法
 * Created by fangchao05 on 2017/8/11.
 */
public class 最长递增子序列长度 {
    public static int getLongestSubSeq(int s[]) {
        int n = s.length;
        int d[] = new int[n];
        int max = d[0];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {

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

        System.out.println(getLongestSubSeq(A));
    }
}
