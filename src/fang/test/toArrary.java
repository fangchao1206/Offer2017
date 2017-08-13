package fang.test;

import java.util.ArrayList;
import java.util.List;

public class toArrary {
public static void main(String[] args) {
	List<Long> list = new ArrayList();  
	list.add(new Long(1));
	list.add(new Long(2));  
	list.add(new Long(3));
	list.add(new Long(4));  
Long[] ll=	new Long[3];
	Long[] l =  list.toArray( new Long[5] );//这个语句会出现ClassCastException
	for(int i=0; i<l.length;i++)
		 System.out.println(l[i] ); 
	 System.out.println("====");
for(int i=0; i<ll.length;i++)
	  System.out.println(ll[i] ); 
}
}
