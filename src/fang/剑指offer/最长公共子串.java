package fang.剑指offer;

import junit.framework.TestCase;

/**
 * Created by fangchao05 on 2017/8/11.
 * 要求连续
 * http://www.hankcs.com/program/algorithm/implementation-and-application-of-nlp-longest-common-subsequence-longest
 * -common-subsequence-of-java.html
 */
public class 最长公共子串 {

    public static int compute(char[] str1, char[] str2) {
        int size1 = str1.length;
        int size2 = str2.length;
        if (size1 == 0 || size2 == 0) {
            return 0;
        }

        // 公共子串的开始位置
        int start1 = -1;
        int start2 = -1;
        // 公共子串最大长度
        int longest = 0;

        // record how many comparisons the solution did;
        // it can be used to know which algorithm is better
        int comparisons = 0;

        for (int i = 0; i < size1; ++i)//从对角线往右上移动
        {
            int m = i;
            int n = 0;
            int length = 0;
            while (m < size1 && n < size2) {
                ++comparisons;
                if (str1[m] != str2[n]) {
                    length = 0;
                } else {
                    ++length;
                    if (longest < length) {
                        longest = length;
                        start1 = m - longest + 1;
                        start2 = n - longest + 1;
                    }
                }

                ++m;
                ++n;
            }
        }

        // shift string2 to find the longest common substring
        for (int j = 1; j < size2; ++j) //从对角线往左下移动
        {
            int m = 0;
            int n = j;
            int length = 0;
            while (m < size1 && n < size2) {
                ++comparisons;
                if (str1[m] != str2[n]) {
                    length = 0;
                } else {
                    ++length;
                    if (longest < length) {
                        longest = length;
                        start1 = m - longest + 1;
                        start2 = n - longest + 1;
                    }
                }

                ++m;
                ++n;
            }
        }
        System.out.printf("from %d of str1 and %d of str2, compared for %d times\n", start1, start2, comparisons);
        return longest;
    }

    public static int longestCommonSubstring(String str1, String str2) {
        return compute(str1.toCharArray(), str2.toCharArray());
    }

    public static void main(String[] args) {
        String a = "www.hankcs.com";
        String b = "hankcs.";
        System.out.println(longestCommonSubstring(a, b));

    }
}
