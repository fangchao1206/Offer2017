package fang.sort;

/**
 * 本例子是jiangxu
 * 小到达
 * 最好： 每次分配都是一个大小为n/2，另一个为n/2-1。这样递归式变为了T (n)≤ 2T (n/2) +Θ(n)，这样的话，时间复杂度就是O(nlgn)
 * 最坏： 跟插入排序一样O(n*n).  数组逆序
 * 平均： O(nlgn)
 *
 * @author fangchao05
 */
public class Fast_sort_jiangxu {
    public static void sort(int[] s, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int x = s[i];
            while (i < j) {
                // 从右向左找第一个小于x的数
                while (i < j && s[j] < x) {//至少有一个是有等于的
                    j--;
                }
                s[i] = s[j];
                // 从左向右找第一个大于等于x的数
                while (i < j && s[i] >= x) {  //至少有一个是有等于的
                    i++;
                }
                s[j] = s[i];
            }
            s[i] = x;
            System.out.println(l + "============" + r);
            sort(s, l, i - 1);   //l  不是0
            sort(s, i + 1, r);   //r 不是len-1
        }

    }

    public static void main(String[] args) {
        int[] aa = {2, 3, 88, 5, 1, 5, 7, 3, 99};
        sort(aa, 0, aa.length - 1);
        for (int m : aa) {
            System.out.println(m);
        }
    }
}
