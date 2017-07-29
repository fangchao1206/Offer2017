package fang.sort;

public class 三数取中 {

	
public static void main(String[] args) {
	int []arr=   {77,8,123};
	int mid=0;
	int min=0;
	min=Math.min(arr[0],arr[1]);
	mid=Math.min(Math.max(arr[0],arr[1]), Math.max(min, arr[2]));
	 System.out.println(mid);
	
	 
	
}
}
