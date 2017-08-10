package fang.sort;

import java.util.Arrays;
/**
 * 
 最坏时间复杂度 O(nlogn)
最优时间复杂度	O(nlogn)
平均时间复杂度	 Theta(nlog n)
空间复杂度	  O(n) total,  O(1) auxiliary
 * @author fangchao05
 *本例子 是大顶堆
 */
public class HeapSort {
    
    private int[] arr;
    
    public HeapSort(int[] arr){
        this.arr = arr;
    }
    
    /**
     * 堆排序的主要入口方法，共两步。
     */
    public void sort(){
        /*
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = arr.length - 1;
        int beginIndex = (len - 1) >> 1; 
        for(int i = beginIndex; i >= 0; i--){
            maxHeapify(i, len);
        }
        
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for(int i = len; i > 0; i--){
        	System.out.println("第"+(arr.length-i)+"个弹出的数:"+arr[0]);
            swap(0, i);
            maxHeapify(0, i-1);
        }
    }
    
    private void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     * 
     * @param index 需要堆化处理的数据的索引(从哪个点开始调整)
     * @param len 未排序的堆（数组）的长度 (从0开始 最后一个的索引)
     */
    private void maxHeapify(int index,int len){
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。
        
        if(li >  len ) return;       // 左子节点索引超出计算范围，直接返回。   li>len不能变
        if(ri<=len&&  arr[ri] > arr[li]) // 先判断左右子节点，哪个较大。   //ri<=len也不能少
            cMax = ri;
        if(arr[cMax] > arr[index]){
            swap(cMax, index);      // 如果父节点被子节点调换，
            maxHeapify(cMax, len);  // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }
    
    /**
     * 测试用例
     * 
     * 输出：
     * [0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9]
     */
    public static void main(String[] args) {
        int[] arr = new int[]{6,1,2,8,5,3,2,1};
        new HeapSort(arr).sort();        
        System.out.println(Arrays.toString(arr));
    }
    
}