package NiukeTest;

public class PrivateObject {
 
	private String privateString = null;
   static  PrivateObject p=new PrivateObject("");
	public PrivateObject(String privateString) {
		 System.out.println("构造函数");
	}
	  
	{
		System.out.println("一般代码块");
	}
	static{
		System.out.println("静态代码块");
	}
 

	public static void main(String[] args) {
		 System.out.println("-----------------\n\n");
		new PrivateObject("");
	}
}