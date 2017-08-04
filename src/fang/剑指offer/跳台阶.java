package fang.剑指offer;

/**
 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * Created by fangchao05 on 2017/7/31.
 */
public class 跳台阶 {
    public int JumpFloor(int target) {
       if(target==1){
           return 1;
       } else if(target==2){
           return 2;
       }
       return 2* JumpFloor(target-1);

    }
}
