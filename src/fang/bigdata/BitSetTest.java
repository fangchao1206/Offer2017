package fang.bigdata;

import java.util.BitSet;

public class BitSetTest {
	public static void main(String[] args) {  
        BitSet bm=new BitSet();  
        System.out.println(bm.isEmpty()+"--"+bm.size());  
        bm.set(0);  
        System.out.println(bm.isEmpty()+"--"+bm.size());  
        bm.set(1);  
        System.out.println(bm.isEmpty()+"--"+bm.size());  
        System.out.println(bm.get(65));  
        System.out.println(bm.isEmpty()+"--"+bm.size());  
         System.out.println("b.get(65)=="+bm.get(65));  
        System.out.println(bm.isEmpty()+"---------"+bm.size());  
        
        System.out.println(~1);
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(127));
        
    }  
}
