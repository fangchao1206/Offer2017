package fang.sort;
/**
 * 冒泡排序是稳定的   不稳定：选择 快排 堆   希尔
 * @author fangchao05
 *最坏运行时间：O（n^2）
 *最佳：O（n） 
 *平均：0（n^2）
 */
public class Bubble_sort {
	
	
/**
 *最坏运行时间：O（n^2）
 *最佳：O（n^2）
 *插入排序的速度直接是逆序对的个数
 *而冒泡执行交换的次数是逆序对的个数 因此冒泡排序执行时间至少是逆序对的
 * @param s
 */
public static void sort(int []s){
	int t;
	for(int i=1;i<=s.length-1;i++){
		for(int j=0;j<s.length-i;j++){
			if(s[j]<s[j+1]){   // >升序           <降序
				t=s[j+1];
				s[j+1]=s[j];
				s[j]=t;
			}
		}
	}
}

//
//	排序算法还可以进行优化，设置一个标志域flag，
//	如果某一趟排序发生了变换，那么flag为true。
//	如果某一趟排序没有发生交换，则说明序列已经有序了，不必再进行继续的比较操作，此时flag为false。

	/**
	 * 最坏运行时间：O（n^2）
	 *最佳：O（n）
	 * @param s
	 */
	public static void sort1(int []s){
	int t;
	boolean flag=true;
	for(int i=1;i<=s.length-1&&flag;i++){
		flag=false;
		for(int j=0;j<=s.length-i-1;j++){
			if(s[j]<s[j+1]){   // >升序           <降序
				t=s[j+1];
				s[j+1]=s[j];
				s[j]=t;
				flag=true;//有交换，表明当前序列尚未有序，标志为ture
			}
		}
	}
}

	public static void main(String[] args) {
		int[] aa = {8, 1, 7, 2, 3, 9, 6, 10};
		sort1(aa);
		for (int m : aa) {
			System.out.println(m);
		}
	}
}
