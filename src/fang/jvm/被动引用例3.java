package fang.jvm;

/**
 *常量在调用阶段会存入调用类的常量池中，本质上并没有直接引用到定义类的常量，
 * 因此不会触发定义这个常量的类的初始化
 */
public class 被动引用例3 {
    public static void main(String[] args) {

        System.out.println(ConstClass.HELLO);
    }


}

class ConstClass {
    static {
        System.out.println("ConstClass 初始化");
    }
    //public static  String HELLO="hello world";
    public static final int HELLO=1;
    public static final String HELLO_WORLD="hello world";
}




