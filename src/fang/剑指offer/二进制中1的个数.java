package fang.剑指offer;

/**
 * Created by fangchao05 on 2017/7/31.
 */
public class 二进制中1的个数 {

    public static int numberOfOne(int n) {
        // 记录数字中1的位数
        int result = 0;

        // JAVA语言规范中，int整形占四个字节，总计32位
        // 对每一个位置与1进行求与操作，再累加就可以求出当前数字的表示是多少位1
        for (int i = 0; i < 32; i++) {
           result+=(n&1);
           n>>>=1;
        }

        // 返回求得的结果
        return result;
    }


















    // ///////////////////////////////////////
        public static void main(String[] args) {
            int number = -2147483648;
            //原始数二进制
            printInfo(number);

            //左移一位  //丢掉坐最高位地位补0
            printInfo(number << 1);

            //右移一位   //左边正数补0 负数补1
            printInfo(number >> 1);

            //无符号右移一位   //高位补0
            printInfo(number >>> 1);

            System.out.println(numberOfOne(0B10000001001000000101110000100001));

        }

        /**
         * 输出一个int的二进制数
         * @param num
         */
        private static void printInfo(int num){
            System.out.println(Integer.toBinaryString(num));

    }
}
