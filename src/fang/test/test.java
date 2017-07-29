package fang.test;

public class test {
	 
	    public static void main(String[] args) {
	        Person[] students;
	        students = new Person[2];
	        Person zhang = new Person(1);
	        zhang.age = 15;
	        zhang.height = 158;

	        Person lee = new Person(2);
	        lee.age = 16;
	        lee.height = 161;

	        students[0] = zhang;
	        students[1] = lee;
	        lee.info(); // 我的年龄是：16,我的身高是：161.0
	        lee.age=18;
	        lee.info();// 18
	        students[1].info(); // 我的年龄是：18,我的身高是：161.0
	    }
	      
}
