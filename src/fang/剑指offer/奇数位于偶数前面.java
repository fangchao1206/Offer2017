package fang.剑指offer;

/**
 * 类似 快排
 * Created by fangchao05 on 2017/8/1.
 */
public class 奇数位于偶数前面 {
    public static void reorderOddEven(int []arr) {
      int i=0;
      int j=arr.length-1;
      while(i<j){
          while(i<j&&arr[j]%2==0){
              j--;
          }
          while (i<j&&arr[i]%2==1){
              i++;
          }
          //交换
          int t=arr[i];
          arr[i]=arr[j];
          arr[j]=t;
      }
    }



    public static void main(String[] args) {
        int[] array = {0, 2, 6, 12, 4, 5, 16, 7, 8, 9,10,1};
        reorderOddEven(array);
        printArray(array);
    }
    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

