package fang.jvm;

public class 被动引用例1 {
    static{
        System.out.println("父类 初始化");
    }
static int va=0;
    public static void main(String[] args) {
        System.out.println(SubClass.va);
    }

}


class SubClass extends 被动引用例1{
    static {
        System.out.println("子类 初始化");
    }

}

