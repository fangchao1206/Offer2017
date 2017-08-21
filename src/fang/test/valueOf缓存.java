package fang.test;

public class valueOf缓存 {
    public static void main(String[] args) {
//        Integer i1 = Integer.valueOf(12);
        int i1 =12;
        Integer i11 =12;//底层是valueof(1222)
        int i2 = Integer.valueOf(12);
        Integer i3 = Integer.valueOf(129);
        Integer i4 = Integer.valueOf(129);
        System.out.println(i1==i2);
        System.out.println(i1==i11);
        System.out.println(i3==i4);
      //  System.out.println(i1.equals(i2));
        System.out.println(i3.equals(i4));
    }
}
