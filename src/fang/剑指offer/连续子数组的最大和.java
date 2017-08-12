package fang.剑指offer;

/**
 * 输入一个整型数组，数组里有正数也有负数。
 * 数组中一个或连续的多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * Created by fangchao05 on 2017/8/10.
 */
public class 连续子数组的最大和 {

    /**
     * 题目2 输入一个整型数组，数组里有正数也有负数。数组中一个或连
     * 续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
     *
     * @param arr 输入数组
     *
     * @return 最大的连续子数组和
     */
    public static int findGreatestSumOfSubArray(int[] arr) {
        // 参数校验
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Array must contain an element");
        }

        // 记录最大的子数组和，开始时是最小的整数
        int max = Integer.MIN_VALUE;
        // 当前的和
        int curMax = 0;
        // 数组遍历
        for (int i : arr) {
            if (curMax + i < i) {//   如果加上这个数还不如他自己大 就从这个数重新开始算
                curMax = i;
            } else {
                curMax += i;

            }
            // 更新记录到的最在的子数组和
            if (max < curMax) {
                max = curMax;
            }
        }

        return max;
    }

    /**
     * 利用动态规划的思想
     *
     * @param arr
     *
     * @return
     */
    public static int findGreatestSumOfSubArray2(int[] arr) {
        return 0;
    }

    public static void main(String[] args) {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};

        System.out.println(findGreatestSumOfSubArray(data));
        System.out.println(findGreatestSumOfSubArray(data2));
        System.out.println(findGreatestSumOfSubArray(data3));
    }
}
