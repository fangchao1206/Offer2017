package NiukeTest;

public class Parent1 {
 private  int aa=1;
  static int b=0;

 final Son1 fun(Integer a, Integer b){
	 final int c;
	 c=6;
	 int bb=8;
	 System.err.println(this.b);
	 
	 return null;
 }
 
 public  final static native void f1();
	public static void main(String[] args) {
		 new Son1().test();
		 Parent1 p=new Parent1();
		 char cc []={'a','b','c'};
		 System.out.println("abc".equals(cc));
		System.out.println(p.aa);

	}

}


class Son1 extends Parent1{
 
	  void test(){
		  this.fun(1, 2);
	  }
}
