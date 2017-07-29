package fang.test;

public class Person {
    public int age; // 年龄
    public double height; // 身高
    public void info() {
        System.out.println("我的年龄是："+age+",我的身高是："+height);
    }
  public Person(int a){
	  System.out.println(2);
  }
    public static void main(String[] args) {
	man name= new  man(1);
	name.info();
	}

}

class man extends Person{
	public man(int a){
		super(a);
		System.out.println(1);
	}
	@Override
	public void info() {
	 System.out.println("son info");
	}
}
