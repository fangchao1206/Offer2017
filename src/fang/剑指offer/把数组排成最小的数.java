package fang.剑指offer;

import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * {3， 32, 321}，则扫描输出这3 个数字能排成的最小数字321323。
 * 自定义大小
 * 并用快排排序
 * http://blog.csdn.net/DERRANTCM/article/details/46753221
 */
public class 把数组排成最小的数 {
    /**
     * 自定义一个比较器
     */
    static class MComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null || o2 == null) {
                throw new IllegalArgumentException("Arg should not be null");
            }

            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);

        }
    }
    public static void fastsort(String[] array, int l, int r, Comparator<String> comparator) {
        if (l < r) {
            int i = l, j = r;
            String x = array[i];
            while (i < j) {
                while (i < j && comparator.compare(array[j], x) > 0) {
                    j--;
                }
                array[i] = array[j];
                while (i < j && comparator.compare(array[i], x) <= 0) {
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = x;
            fastsort(array, l, i - 1, comparator);
            fastsort(array, i + 1, r, comparator);
        }
    }

    public static String printMinNumber(String[] array) {

        if (array == null || array.length < 1) {
            throw new IllegalArgumentException("Array must contain value");
        }

        MComparator comparator = new MComparator();
        fastsort(array, 0, array.length - 1, comparator);

        StringBuilder builder = new StringBuilder();

        for (String s : array) {
            builder.append(s);
        }

        return builder.toString();
    }












    public static void main(String[] args) {

        String[] data = {"3", "5", "1", "4", "2"};
        System.out.println(printMinNumber(data));

        String[] data2 = {"3", "32", "321"};
        System.out.println(printMinNumber(data2));

        String[] data3 = {"3", "323", "32123"};
        System.out.println(printMinNumber(data3));

        String[] data4 = {"1", "11", "111"};
        System.out.println(printMinNumber(data4));

        String[] data5 = {"321"};
        System.out.println(printMinNumber(data5));
    }


}
