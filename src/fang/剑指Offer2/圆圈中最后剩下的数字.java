package fang.剑指Offer2;

import java.util.LinkedList;
import java.util.List;

public class 圆圈中最后剩下的数字 {
//    第一种：经典的解法， 用环形链表模拟圆圈。
public static int lastRemaining(int n, int m) {
    if (n < 1 || m < 1) {
        return -1;
    }

    List<Integer> list = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        list.add(i);
    }

    // 要删除元素的位置
    int idx = 0;
    // 开始计数的位置
    int start = 0;

    while (list.size() > 1) {

        // 只要移动m-1次就可以移动到下一个要删除的元素上
        for (int i = 1; i < m; i++) {
            idx = (idx + 1) % list.size(); // 【A】
        }

        list.remove(idx);

        // 确保idx指向每一轮的第一个位置
        // 下面的可以不用，【A】已经可以保证其正确性了，可以分析n=6，m=6的第一次删除情况
        //  if (idx == list.size()) {
        //      idx = 0;
        //  }
    }

    return list.get(0);
}

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3)); // 最后余下3
        System.out.println(lastRemaining(5, 2)); // 最后余下2
        System.out.println(lastRemaining(6, 7)); // 最后余下4
        System.out.println(lastRemaining(6, 6)); // 最后余下3
        System.out.println(lastRemaining(0, 0)); // 最后余下-1
    }
}
