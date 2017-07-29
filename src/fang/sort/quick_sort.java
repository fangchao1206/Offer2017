package fang.sort;
public class quick_sort {
	static int[] arr;

	private static void swap(int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	private static void quick_sort_recursive(int start, int end) {
		if (start >= end)
			return;
		int mid = arr[end];
		int left = start, right = end - 1;
		while (left < right) {
			while (arr[left] <= mid && left < right)
				left++;
			while (arr[right] >= mid && left < right)
				right--;
			swap(left, right);
		}
		if (arr[left] >= arr[end])
			swap(left, end);
		 else
		     // left++;//  
			 left=end;//和上面那句等价
		quick_sort_recursive(start, left - 1);
		quick_sort_recursive(left + 1, end);
	}

	public static void sort(int[] arrin) {
		arr = arrin;
		quick_sort_recursive(0, arr.length - 1);
	}
	
	
	 public static void main(String[] args) {
			int [] aa={9,8,7,6,5,4,3,97,8,99};
			sort(aa);
			for(int m:aa){
				System.out.println(m);
			}
		}
	
}