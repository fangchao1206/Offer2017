package fang.剑指Offer2;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷四则运算符号。
 * <p>
 * <p>
 * http://blog.csdn.net/derrantcm/article/details/46798763
 */
public class 用位运算实现加法47 {
    public static int add(int x, int y) {
        int sum;
        int carry;

        do {
            sum = x ^ y;      //各位求和
            // x&y的某一位是1说明，它是它的前一位的进位，所以向左移动一位
            carry = (x & y) << 1;//单独算进位

            x = sum;
            y = carry;
        } while (y != 0);

        return x;
    }


    public static void main(String[] args) {
        System.out.println(add(1, 2) + ", " + (1 + 2));
        System.out.println(add(13, 34) + ", " + (13 + 34));
        System.out.println(add(19, 85) + ", " + (19 + 95));
        System.out.println(add(865, 245) + ", " + (865 + 245));
    }
}
