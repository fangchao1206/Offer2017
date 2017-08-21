package fang.jvm;

/**
 * 2.通过定义类的数组来引用类，不会触发类的初始化
 */
public class 被动引用例2 {
    public static void main(String[] args) {
        Super supers[]=new Super[1];
    }


}

class Super {
    static {
        System.out.println("父类 初始化");
    }
}




