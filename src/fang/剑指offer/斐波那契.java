package fang.剑指offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * Created by fangchao05 on 2017/7/31.
 */
public class 斐波那契 {
    /**
     * 使用中间变量
     * @param n
     * @return
     */
    static public int Fibonacci(int n) {
        int c = 3;
        int a = 1, b = 1, t = 0;
        if (n == 1 || n == 2) {
            return 1;
        }
        while (c <= n) {
            c++;
            t = a + b;
            a = b;
            b = t;

        }
        return t;
    }

    /**
     * 使用数组
     * @param n
     * @return
     */
    static public int Fibonacci1(int n) {
        int arr[] = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];

    }

    public static void main(String[] args) {
        System.out.println(Fibonacci1(5));
    }
}
