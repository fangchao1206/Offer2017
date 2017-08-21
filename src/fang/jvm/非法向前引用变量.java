package fang.jvm;

public class 非法向前引用变量 {


    static {
        i = 8;

    }
    static int i=7;
    static {
        System.out.println(i);
    }

    public static void main(String[] args) {

    }
}
