package NiukeTest;

import NiukeTest.OuterClass.InnerClass1;
import NiukeTest.OuterClass.InnerClass2;

public class OutclassTest {
	 
		 public static void main(String[] args) {
			 /* 外围类访问静态内部类：内部类. */
		        System.out.println(InnerClass1._name1);
		        /* 静态内部类 可以直接创建实例不需要依赖于外围类 */
		          new InnerClass1().display();
System.out.println("------");
new OuterClass().display();
System.out.println("------");
		        /* 非静态内部的创建需要依赖于外围类 */
		         InnerClass2 inner2 =  new OuterClass(). new InnerClass2();
		        /* 访问非静态内部类的成员需要使用非静态内部类的实例 */
		        System.out.println(inner2._name2);
		        inner2.display();
		    }
	
}
