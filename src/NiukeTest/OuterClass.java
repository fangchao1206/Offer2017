package NiukeTest;

 
import java.util.ArrayList;
import java.util.List;

public class OuterClass {
    private String sex;
    public static String name = "chenssy";

    /**
     *静态内部类  不能访问外部非静态成员
     */
    static class InnerClass1{
        /* 在静态内部类中可以存在静态成员 */
        public static String _name1 = "chenssy_static";

        public void display(){
            /*
             * 静态内部类只能访问外围类的静态成员变量和方法
             * 不能访问外围类的非静态成员变量和方法
             */
            System.out.println("inner1 static  OutClass name :" + name);
        }
    }

    /**
     * 非静态内部类   可以引用外部的静态  但不能自己定义静态的
     */
    class InnerClass2{
        /* 非静态内部类中不能存在静态成员 因为它与实例绑在一起 只有外部的类被实例化后 这个内部类才可以被实例化*/
        public String _name2 = "chenssy_inner";
        /* 非静态内部类中可以调用外围类的任何成员,不管是静态的还是非静态的 */
        public void display(){
            System.out.println("innner 2 OuterClass name：" + name);
        }
    }

    /**
     * @desc 外围类方法
     * @author chenssy
     * @data 2013-10-25
     * @return void
     */
    public void display(){
        /* 外围类访问静态内部类：内部类. */
        System.out.println(InnerClass1._name1);
        /* 静态内部类 可以直接创建实例不需要依赖于外围类 */
          new InnerClass2().display();

        /* 非静态内部的创建需要依赖于外围类 */
       InnerClass2 inner2 =  new InnerClass2();
        /* 访问非静态内部类的成员需要使用非静态内部类的实例 */
        System.out.println(inner2._name2);
        inner2.display();
    }
public static void main(String[] args) {
	List   list=new ArrayList<>();
	 list.add(1);
	 List list2=list;
	System.out.println(list2.get(0) instanceof Integer);
}
   
}

