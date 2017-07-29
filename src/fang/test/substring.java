package fang.test;

public class substring {
public static void main(String[] args) {
	String ss="12345678901";
	if(ss.length()>10){
		ss=ss.substring(0,10);
	}
	System.out.println(ss);
}
}
