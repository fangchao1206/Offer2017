package fang.剑指offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * Created by fangchao05 on 2017/8/1.
 */
public class 数值的整数次方 {

    public static double power(double base, int exponent) {
        // 指数和底数不能同时为0
        if (base == 0 && exponent == 0) {
            throw new RuntimeException("invalid input. base and exponent both are zero");
        }
        int exp = exponent;
        if (exponent < 0) {
            exp = -exponent;//求绝对值
        }
        double result = powerWithUnsignedExponent1(base, exp );
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    public static double powerWithUnsignedExponent(double base, long exponent) {
        // 如果指数为0，返回1
        if (exponent == 0) {
            return 1;
        }

        // 指数为1，返回底数
        if (exponent == 1) {
            return base;
        }

        // 递归求一半的值
        double result = powerWithUnsignedExponent(base, exponent >> 1);

        // 求最终的值，如果是奇数就还要剩以一次底数
        result *= result;
        if (exponent % 2 != 0) {
            result *= base;
        }

        // 返回结果
        return result;
    }

    public static double powerWithUnsignedExponent1(double base, long exponent) {
        double result = 1;
        while (exponent > 0) {
            result *= base;
            exponent--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(0.0000000000000000000000000000000000000000001 == 0);
        System.out.println(0.0000000000000000000000000000 == 0);

        System.out.println(power(2, -4));
        System.out.println(power(2, 4));
        System.out.println(power(2, 0));
        System.out.println(power(0.00000000000000000000000000001, -1));
        System.out.println(power(0.00000000000000000000000000001, 1));
        System.out.println(power(0.00000000000000000000000000001, 0));
        System.out.println(power(0.00000000000000000000000000000, 0));
    }
}
