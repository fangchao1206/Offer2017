package fang.sort;

/**
 * 插入排序  稳定的
 *
 * @author fangchao05
 *         插入排序的时间复杂度分析。在最坏情况下，数组完全逆序，
 *         插入第2个元素时要考察前1个元素，插入第3个元素时，要考虑前2个元素，……，插入第N个元素，
 *         要考虑前 N - 1 个元素。因此，最坏情况下的比较次数是 1 + 2 + 3 + ... + (N - 1) 即逆序对个数，等差数列求和，结果为 N^2 / 2，
 *         所以最坏情况下的复杂度为 O(N^2)。
 *         最好情况下，数组已经是有序的，每插入一个元素，只需要考查前一个元素，因此最好情况下，插入排序的时间复杂度为O(N)。
 *
 *         平均：o（n^2）
 */
public class Insertion_sort {
    //前i-1个已经排好
    public static void sort(int[] s) {
        for (int i = 1; i <= s.length-1; i++) {
            int temp = s[i];//要插入的数据
            int j = i - 1;
            while (j >= 0 &&  temp>s[j]) {   //temp>s[j] 降序    temp<s[j]升序
                s[j + 1] = s[j];
                j--;
            }
            s[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] aa = {2, 3, 4, 1, 5, 7,6,5,1,4};
        sort(aa);
        for (int m : aa) {
            System.out.println(m);
        }
    }

}
