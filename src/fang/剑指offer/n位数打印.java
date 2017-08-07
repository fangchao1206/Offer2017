package fang.剑指offer;

/**
 * Created by fangchao05 on 2017/8/7.
 */
public class n位数打印 {

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
     *
     * @param n 数字的最大位数
     */
    public static void printOneToNthDigits(int n) {
        // 输入的数字不能为小于1
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }
        // 创建一个数组用于打存放值
        int[] arr = new int[n];
        // 为数组元素赋初始值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        while (addOne(arr) == 0) {
            printArr(arr);
        }
    }

    /**
     * 每addOne一次就输出当前的arr
     *
     * @param arr
     */
    private static void printArr(int[] arr) {
        int index = 0;
        //去除前面的0
        while( index < arr.length && arr[index] == 0  ) {
            index++;
        }
        for(;index<arr.length;index++){
            System.out.print(arr[index]);
        }
        System.out.println();
    }

    /**
     * 对arr表示的数组的最低位加1 arr中的每个数都不能超过9不能小于0，每个位置模拟一个数位
     *
     * @param arr 待加数组
     *
     * @return 判断最高位是否有进位，如果有进位就返回1，否则返回0
     */
    private static int addOne(int[] arr) {
        // 保存进位值，因为每次最低位加1
        int carry = 1;
        // 最低位的位置的后一位
        int index = arr.length;
        while (carry != 0 && index > 0) {
            index--;
            arr[index] += carry;
            carry = arr[index] / 10;
            arr[index] %= 10;
        }
        // 如果index=0说明已经处理了最高位，carry>0说明最高位有进位，返回1
        if (carry > 0 && index == 0) {
            return 1;
        }

        // 无进位返回0
        return 0;
    }
    public static void main(String[] args) {
        printOneToNthDigits(3);
    }
}
