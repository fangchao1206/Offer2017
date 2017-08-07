package fang.剑指offer;

import java.util.Stack;

/**
 * Created by fangchao05 on 2017/8/7.
 */
public class 栈的压入弹出序列 {
    public static boolean isPopOrder(int[] push, int[] pop) {
        // 输入校验，参数不能为空，并且两个数组中必须有数字，并且两个数组中的数字个数相同
        // 否则返回false
        if (push == null || pop == null || pop.length == 0 || push.length == 0 || push.length != pop.length) {
            return false;
        }
        boolean flag = false;
        Stack<Integer>statck=new Stack();
        int j=0;
        for(int i=0;i<push.length;i++){
            statck.push(push[i]);

            while (j<pop.length&&!statck.isEmpty()&&pop[j]==statck.peek()){
                j++;
                statck.pop();
            }
        }
        if(j==pop.length){
           return  true;
        }
        return false;
    }



    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {1, 2, 3, 4, 5};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 2, 1};

        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("true: " + isPopOrder(push, pop4));

        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5));

        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6));

        System.out.println("false: " + isPopOrder(null, null));

//        // 测试方法2
//        System.out.println();
//        System.out.println("true: " + isPopOrder2(push, pop1));
//        System.out.println("true: " + isPopOrder2(push, pop2));
//        System.out.println("false: " + isPopOrder2(push, pop3));
//        System.out.println("false: " + isPopOrder2(push, pop4));
//        System.out.println("false: " + isPopOrder2(push5, pop5));
//        System.out.println("true: " + isPopOrder2(push6, pop6));
//        System.out.println("false: " + isPopOrder2(null, null));
    }
}
