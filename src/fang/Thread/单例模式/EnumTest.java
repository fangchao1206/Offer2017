package fang.Thread.单例模式;

/** (1) 构造器只是在构造枚举值的时候（第一次使用的时候，哪怕只使用一个 所有的都会被构造）
 * 被调用。且只调用一次
 * http://www.cnblogs.com/frankliiu-java/archive/2010/12/07/1898721.html
 * Created by fangchao05 on 2017/7/29.
 */

 enum EnumTest {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6) {
        @Override
        public boolean isRest111() {
            return true;
        }
    },
    SUN(0) {
        @Override
        public boolean isRest111() {
            return true;
        }
    };

    private int value;

    private EnumTest(int value) {
        System.out.println("构造器");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isRest111() {
        return false;
    }
}
 class Mian {
    public static void main(String[] args) {
//        System.out.println("EnumTest.FRI 的 value = " + EnumTest.FRI.getValue());
//        System.out.println(EnumTest.FRI.isRest111());
       System.out.println(EnumTest.SAT.isRest111());
    }
}
