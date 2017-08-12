package fang.剑指offer;

/**
 * Created by fangchao05 on 2017/8/11.
 * 不要求连续
 * 用动态规划
 */
public class 最长公共子序列 {

    public static int compute(char[] str1, char[] str2) {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;

        // 构造二维数组记录子问题A[i]和B[j]的LCS的长度
        int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];//大一圈  存0  初始值

        // 从后向前，动态规划计算所有子问题。也可从前到后。
        for (int i = substringLength1 - 1; i >= 0; i--) {
            for (int j = substringLength2 - 1; j >= 0; j--) {
                if (str1[i] == str2[j]) {
                    opt[i][j] = opt[i + 1][j + 1] + 1;// 状态转移方程
                } else {
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);// 状态转移方程
                }
            }
        }
        System.out.println("substring1:" + new String(str1));
        System.out.println("substring2:" + new String(str2));
        System.out.print("LCS:");

        int i = 0, j = 0;
        while (i < substringLength1 && j < substringLength2) {
            if (str1[i] == str2[j]) {
                System.out.print(str1[i]);
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1]) {  // >=  和 > 结果不一样  前者是向下找  后者是向右找
                i++;
            } else {
                j++;
            }
        }
        System.out.println();
        for (int b[] : opt) {
            for (int m : b) {
                System.out.print(" " + m);
            }
            System.out.println();
        }
        return opt[0][0];
    }

    public static int compute(String str1, String str2) {
        return compute(str1.toCharArray(), str2.toCharArray());
    }

    public static void main(String[] args) {
        //        String a = "Tom HCanks";
        //        String b = "Hankcs";
        String a = "BDCABA";
        String b = "ABCBDAB";

        System.out.println(compute(a, b));

    }
}
