package fang.剑指offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * Created by fangchao05 on 2017/7/31.
 * n=1 - 只有横放一个矩形一种解决办法
 * n=2 - 有横放一个矩形，竖放两个矩形两种解决办法
 * n=3 - n=2的基础上加1个横向，n=1的基础上加2个竖向
 * n=4 - n=3的基础上加1个横向，n=2的基础上加2个竖向
 * ·
 * ·
 * ·
 * n=n - n = f(n-1) + f(n-2)
 * 类似青蛙跳台阶
 */

/**
 * 递归可能会超时
 */
public class 矩形覆盖 {
    public int RectCover(int target) {
    /*    if(target==0){
            return 0;
        }else if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }
        return  RectCover(target-1)+RectCover(target-1);*/

        int c=3;
        int a=1,b=2,t=0;
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        while(c<=target){
            c++;
            t=a+b;
            a=b;
            b=t;

        }
        return t;
    }
}
