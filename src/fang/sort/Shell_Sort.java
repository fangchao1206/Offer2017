package fang.sort;
/**
 * 不稳定   对于相同的两个数，可能由于分在不同的组中而导致它们的顺序发生变化
 * 最优时间复杂度：O(n)
 * 最坏时间复杂度：根据步长不同会有所不同
 * 
 * 步长                     最坏情况复杂度
 * {n/2^i}       O(n^2)
 * 2^k-1         O(n^3/2)
 * 2^i*3^j       O(nlog^2n)
 * 
 * @author fangchao05
 *
 */
public class Shell_Sort {
  public static void sort(int []s){
	  int n=s.length;
	  int gap;
	  int i=0,j=0;
	 for(gap=n/2;gap>0;gap/=2){
		 for(i=0;i<gap;i++){
			
			 for( j=i+gap;j<n;j+=gap){
				 int t=s[j];                 //需要gap个t 所以空间复杂度为O(n)
				 int k=j-gap;
				 while(k>=0&&s[k]<t){//<降序
					 
					 s[k+gap]=s[k];
					 k-=gap;
				 }
				 s[k+gap]=t;
			 }
		 }
	 }
  }
  
  
  public static void main(String[] args) {
		int [] aa={2,3,4,71,12,545,3,1,5,7,3};
		sort(aa);
		for(int m:aa){
			System.out.println(m);
		}
	}
  
}
