package NiukeTest;

public   class Parent {
 
 private static int a=0;
 int a(int a){
	return 0;}
 void a(float b){}
 public static void main(String[] args) {
	 new Son(1).test();
	  
}
}

  interface IntFace{
	int a=0;
}
    class Son extends Parent{
    	public Son(int i){
     	final int a=0;
    		
    		char s='就';
    	}
 void test(){
	 System.out.println(super.getClass().getName());
	 System.out.println(this.getClass().getName());
	 System.out.println(super.getClass().getSuperclass().getName());
	 System.out.println(new Parent().getClass().getName());
	 System.out.println((new int[3]).getClass().getName());
	 System.out.println((new Parent [3]).getClass().getName());
	 System.out.println((new Son [3]).getClass().getName());
 
 }
    }
