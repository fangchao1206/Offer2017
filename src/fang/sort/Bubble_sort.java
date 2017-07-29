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
	for(int i=1;i<=s.length;i++){
		for(int j=0;j<s.length-i;j++){
			if(s[j]<s[j+1]){   // >升序           <降序
				t=s[j+1];
				s[j+1]=s[j];
				s[j]=t;
			}
		}
	}
}


public static void main(String[] args) {
	int [] aa={2,3,4,1,5,7,3};
	sort(aa);
	for(int m:aa){
		System.out.println(m);
	}
}
}
