package fang.剑指Offer2;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class 数组中只出现一次的数字40 {
    public static int[] findNumbersAppearanceOnce(int data[]) {
        int result[];
        result = new int[]{0, 0};
        //挨个异或  一样的是零就被过滤掉了，得到那两个要获取的数字的异或的结果
        int xor = 0;
        for (int n : data) {
            xor = xor ^ n;
        }

//根据这个异或的结果 找到这两个数字二进制形式第一位数字不一样的位置
        int index = getIndexOfFirst1(xor);

        //然后根据这个倒数第index位是否是1分为两组，那两个不一样的肯定被分到了两组里 然后再分别单组异或出来的结果就是最终结果
        for (int d : data) {
            if (IsIndex1(d, index)) {
               result [0]^=d;
            }else{
                result[1]^=d;
            }
        }

        return result;
    }

    /**
     * 判断数字d的倒数第index位是否是1
     *
     * @param d
     * @return
     */
    private static boolean IsIndex1(int d, int index) {

        d >>>= index;

        return (d & 1) == 1;
    }

    private static int getIndexOfFirst1(int xor) {
        int i = 0;
        while ((xor & 1) == 0 && i < 32) {
            i++;
            xor >>>= 1;
        }
        return i;
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(IsIndex1(2,1));//true
        System.out.println(Integer.parseInt("1010",2));//二进制转十进制
        System.out.println(Integer.valueOf("1010",2));//二进制转十进制  其实底层用的就是parseInt()

            int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
            int[] result1 = findNumbersAppearanceOnce(data1);
            System.out.println(result1[0] + " " + result1[1]);

            int[] data2 = {4, 6};
            int[] result2 = findNumbersAppearanceOnce(data2);
            System.out.println(result2[0] + " " + result2[1]);

            int[] data3 = {4, 6, 1, 1, 1, 1,3,3};
            int[] result3 = findNumbersAppearanceOnce(data3);
            System.out.println(result3[0] + " " + result3[1]);

    }
}
