package fang.find;

/**
 * 复杂度分析： 最坏情况下，关键词比较次数为log 2 (n+1)，且 期望时间复杂度为O(log 2 n) ；
 */
public class 二分查找 {
   static int BinarySearch1(int a[], int value, int n) {
        int low, high, mid;
        low = 0;
        high = n - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            }
            if (a[mid] < value) {
                low = mid + 1;
            }
            if (a[mid] > value) {
                high=mid-1;
            }
        }
        return -1;
    }

    /**
     * 版本2  递归
     * @param a
     * @param value
     * @param n
     * @return
     */
    static int BinarySearch2(int a[], int value, int n) {
        int low, high, mid;
        low = 0;
        high = n - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            }
            if (a[mid] < value) {
                return BinarySearch2(a,mid+1,high);
            }
            if (a[mid] > value) {
                return BinarySearch2(a,low,mid-1);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a={1,2,4,4,6,8,9,10,11,15};
        System.out.println(BinarySearch1(a,8,a.length));
    }
}
