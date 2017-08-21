package fang.剑指Offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 * <p>
 * <p>
 * 我们先在数组中选择两个数字，如果它们的和等于输入的s，我们就找到了要找的两个数字。
 * 如果和小于s 呢？我们希望两个数字的和再大一点。由于数组已经排好序了，
 * 我们可以考虑选择较小的数字后面的数字。因为排在后面的数字要大一些，那么两个
 * 数字的和也要大一些， 就有可能等于输入的数字s 了。同样， 当两个数字的和大于输入
 * 的数字的时候，我们可以选择较大数字前面的数字，因为排在数组前面的数字要小一些。
 */
public class 和为s的两个数字41 {
    public static void findNumbersWithSum(int[] data, int sum) {
        for (int j = 1; j < data.length; j++) {
            for (int i = 0; i < j; i++) {
                if (data[j] + data[i] == sum) {
                    System.out.println(data[i] + "+" + data[j] + "=" + sum);
                }
            }
        }
    }

    public static List<Integer> findNumbersWithSum1(int[] data, int sum) {
        List<Integer> result = new ArrayList<>(2);

        if (data == null || data.length < 2) {
            return result;
        }

        int ahead = data.length - 1;
        int behind = 0;
        long curSum; // 统计和，取long是防止结果溢出

        while (behind < ahead) {
            curSum = data[behind] + data[ahead];

            if (curSum == sum) {
                result.add(data[behind]);
                result.add(data[ahead]);
                break;
            } else if (curSum < sum) {
                behind++;
            } else {
                ahead--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] data1 = {0, 1, 2, 4, 7, 11, 15};
        findNumbersWithSum(data1, 15);
    }
}
