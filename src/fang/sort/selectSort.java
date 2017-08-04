package fang.sort;

/**首先在未排序序列中找到最小（大）元素，
 * 存放到排序序列的起始位置，然后，再从剩余未排序
 * 元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 * Created by fangchao05 on 2017/8/2.
 *
 *好坏平均都是o(n^2)
 * 空间o(1)
 * 不稳定
 *
 */


public class selectSort {
    public static void selectSort(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }

        for (int i = 0; i < data.length - 1; i++) {
            int min = i;// 将当前下标定为最小值下标
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min]) {         //<升序  >降序
                    min = j;
                }
            }

            if (i != min) {
                int tmp = data[i];
                data[i] = data[min];
                data[min] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] aa = {8, 1, 7, 2, 3, 9, 6, 10};
       selectSort(aa);
        for (int m : aa) {
            System.out.println(m);
        }
    }
}
