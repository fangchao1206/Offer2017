package fang.String;
/**http://blog.csdn.net/v_JULY_v/article/details/6322882
 * 字符旋转移动
 * @author fangchao05
 *
 */
public class Rotate {
	
	static void swap(char[] cc,int a,int b){
		char t=cc[a];
		cc[a]=cc[b];
		cc[b]=t;
	}
	 
	
static String rotate(String str,int m){
	if(str.length()==0||m<=0){
	  return "";
	}
	int n=str.length();
	//char cc[]=new char[n];
	char cc[]=str.toCharArray();
	if(m%n<=0){
		return "";
	}
	int p1=0;
	int p2=m;
	int k=n-m-n%m;
	while(k-->0){
		swap(cc, p1, p2);
		p1++;
		p2++;
	}
	// 重点，都在下述几行。    
    // 处理尾部，r为尾部左移次数    
    int r = n - p2;    
	while(r-->0){
		int i=p2;
		while(i>p1){
			swap(cc,i,i-1);
			i--;
		}
		p1++;
		p2++;
	}
String ss=new String(cc);
	return ss;
}

public static void main(String[] args) {
	String ch="abcdefghijk";       
   
    System.out.println( rotate(ch,3));//defghijkabc
}
}
