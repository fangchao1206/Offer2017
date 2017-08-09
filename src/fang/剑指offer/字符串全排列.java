package fang.剑指offer;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc。则打印出由字符a、b、c
 * 所能排列出来的所有字符串abc、acb、bac 、bca、cab 和cba
 * Created by fangchao05 on 2017/8/9.
 * http://blog.csdn.net/DERRANTCM/article/details/46722017
 */
public class 字符串全排列 {
    public static void permutation(char[] chars) {
        // 输入较验
        if (chars == null || chars.length < 1) {
            return;
        }
        // 进行排列操作
        permutation(chars, 0);
    }

    private static void permutation(char[] chars, int start) {
        //结束条件 start==字符串长度-1
        if (chars.length - 1 == start) {
            System.out.println(new String(chars) + " ");
        } else {
            char t;
            for (int i = start; i < chars.length ; i++) {
                t = chars[start];
                chars[start] = chars[i];
                chars[i] = t;
                //处理后面的字符串
                permutation(chars, start + 1);
            }
        }
    }


    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        permutation(c1);
        System.out.println();

        char[] c2 = {'a', 'b', 'c', 'd'};
        permutation(c2);
    }
}
