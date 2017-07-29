package fang.test;

public class Test1 {
    public static void main(String[] args) {

		 String s1 = new StringBuilder("漠").append("然").toString();//17
		 String ss=s1.intern();//17
		 System.out.println(ss == s1);//true

		 String s2 = new StringBuilder("漠").append("然").toString();//24
		   ss=s2.intern();//17
		 System.out.println(s2.intern() == s2);

	}

}
