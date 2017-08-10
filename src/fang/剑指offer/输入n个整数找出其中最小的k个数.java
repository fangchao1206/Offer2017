package fang.剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by fangchao05 on 2017/8/9.
 */
public class 输入n个整数找出其中最小的k个数 {
    // 堆中元素存放的集合
    private List<Integer> items = new ArrayList<>();
    // 用于计数
    private int cursor = -1;

    /**
     * 相当于从index开始 向下调整
     *
     * @param index
     * @param len
     */
    private void maxHeap(int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMaxi = li;             // 子节点值最大索引，默认左子节点。

        if (li > len) {
            return;       // 左子节点索引超出计算范围，直接返回。   li>len不能变
        }
        if (ri <= len && items.get(ri) > items.get(li)) // 先判断左右子节点，哪个较大。   //ri<=len也不能少
        {
            cMaxi = ri;
        }
        if (items.get(cMaxi) > items.get(index)) {
            swap(cMaxi, index);      // 如果父节点被子节点调换s，
            maxHeap(cMaxi, len);  // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }

    private void swap(int i, int j) {
        int temp = items.get(i);
        items.set(i, items.get(j));
        items.set(j, temp);
    }

    /**
     * 向堆中添加一个元素
     *
     * @param item 等待添加的元素
     */
    public void add(Integer item) {
        items.add(item); // 将元素添加到最后
        int len = items.size() - 1;
        int beginIndex = (len - 1) >> 1;//从第一个非叶子节点开始
        for (int i = beginIndex; i >= 0; i--) {
            maxHeap(i, items.size() - 1); // 循环上移，以完成重构
        }

    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶部的元素
     */
    public Integer deleteTop() {
        if (items.isEmpty()) { // 如果堆已经为空，就报出异常
            throw new RuntimeException("The heap is empty.");
        }

        Integer maxItem = items.get(0); // 获取堆顶元素
        Integer lastItem = items.remove(items.size() - 1); // 删除最后一个元素
        if (items.isEmpty()) { // 删除元素后，如果堆为空的情况，说明删除的元素也是堆顶元素
            return lastItem;
        }

        items.set(0, lastItem); // 将删除的元素放入堆顶
        maxHeap(0, items.size() - 1); // 自上向下调整堆
        return maxItem; // 返回堆顶元素
    }

    /**
     * 获取堆中的第一个元素
     *
     * @return 堆中的第一个元素
     */
    public Integer first() {
        if (items.size() == 0) {
            throw new RuntimeException("The heap is empty.");
        }
        return items.get(0);
    }

    /**
     * 判断堆是否为空
     *
     * @return true是，false否
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * 获取堆的大小
     *
     * @return 堆的大小
     */
    public int size() {
        return items.size();
    }

    /**
     * 清空堆
     */
    public void clear() {
        items.clear();
    }

    public static void getLeastNumbers2(int[] input, int[] output) {
        if (input == null || output == null || output.length <= 0 || input.length < output.length) {
            throw new IllegalArgumentException("Invalid args");
        }

        输入n个整数找出其中最小的k个数 maxHeap = new 输入n个整数找出其中最小的k个数();
        for (int in : input) {
            if (maxHeap.size() < output.length) {
                maxHeap.add(in);
            } else {
                int max = maxHeap.first();
                if (max > in) {//如果 堆的最大值 小于新输入的则删除这个最大值 从新入栈in
                    maxHeap.deleteTop();
                    maxHeap.add(in);
                } else {//否则不处理
                }
            }
        }

        for (int i = 0; maxHeap.hasNext(); i++) {
            output[i] = maxHeap.next();
        }
    }

    private int next() {
        cursor++;
        if (cursor >= items.size()) {
            throw new RuntimeException("No more element");
        }

        return items.get(cursor);

    }

    private boolean hasNext() {
        return cursor < items.size() - 1;
    }

    //-----------------------------------------------------------------------------------

    /**
     * 分区算法（类似于快排）
     *
     * @param input 输入数组
     * @param start 开始下标
     * @param end   结束下标
     *
     * @return 分区位置（最终位置）
     */
    private static int partition(int[] input, int start, int end) {
        int tmp = input[start];

        while (start < end) {
            while (start < end && input[end] >= tmp) {
                end--;
            }
            input[start] = input[end];

            while (start < end && input[start] <= tmp) {
                start++;
            }
            input[end] = input[start];
        }

        input[start] = tmp;
        return start;
    }

    /**
     * 题目： 输入n个整数，找出其中最小的k个数。
     * 【第一种解法】
     *
     * @param input  输入数组
     * @param output 输出数组
     */
    public static void getLeastNumbers(int[] input, int[] output) {

        if (input == null || output == null || output.length <= 0 || input.length < output.length) {
            throw new IllegalArgumentException("Invalid args");
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        int target = output.length - 1;//K

        while (index != target) {
            if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);
        }
        //到这一步 前K个一定都比第K个小 K后面的都比input[k]大
        //复制前k个到output
        System.arraycopy(input, 0, output, 0, output.length);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
//        int src[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//        int des[] = {8, 8, 8, 8, 8};
//        System.arraycopy(src, 0, des, 1, 3);
//        for (int i : des) {
//            System.out.println(i);//81238
//        }
        System.out.println("第一种解法：");
        test1();
        System.out.println();
        System.out.println("第二种解法：");
        test2();

    }
    private static void test1() {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};

        int[] output = new int[4];
        getLeastNumbers(data, output);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] output2 = new int[8];
        getLeastNumbers(data, output2);
        for (int i : output2) {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] output3 = new int[1];
        getLeastNumbers(data, output3);
        for (int i : output3) {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] data2 = {4, 5, 1, 6, 2, 7, 2, 8};
        int[] output4 = new int[2];
        getLeastNumbers(data2, output4);
        for (int i : output4) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private static void test2() {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};

        int[] output = new int[4];
        getLeastNumbers2(data, output);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] output2 = new int[8];
        getLeastNumbers2(data, output2);
        for (int i : output2) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] output3 = new int[1];
        getLeastNumbers2(data, output3);
        for (int i : output3) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] data2 = {4, 5, 1, 6, 2, 7, 2, 8};
        int[] output4 = new int[2];
        getLeastNumbers2(data2, output4);
        for (int i : output4) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
