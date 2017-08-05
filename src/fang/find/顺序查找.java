package fang.find;

/**
 * 复杂都为o(n)
 */
public class 顺序查找 {
    static int find(int a[], int x) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={1,2,15,4,8,9,0,1,3};
        System.out.println(find(a,8));
    }
}
