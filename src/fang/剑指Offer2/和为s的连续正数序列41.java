package fang.剑指Offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正数s，打印出所有和为s 的连续正数序列（至少两个数）
 */
public class 和为s的连续正数序列41 {
    public static void findContinuousSequence(int data[],int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (data == null || data.length < 2) {
            return  ;
        }

        int i =0;
        int j = 1;
        long curSum=data[i]+data[j];// 统计和，取long是防止结果溢出
        while(i<data.length&&j<data.length&&i<j){

          if(curSum==sum){
              System.out.println(i+"~"+j);
              break;
          }else if(curSum<sum){
              j++;
              if(j<data.length)
              curSum+=data[j];
          }else {
              if(i<j)
              curSum-=data[i];
              i++;
          }
        }
    }

    public static void main(String[] args) {
        int[] data3 = {1, 2, 3, 5, 11, 16};
        findContinuousSequence(data3,22);
    }
}
