package fang.test;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class 粉笔 {
    public static void main(String[] args) {
       // int a = 1,b = 2,c = 3,d = 3,x=2,y=1,z = 3,m = 5,n = 5;
        Scanner in = new Scanner(System.in);
      int n=in.nextInt();
      int m=in.nextInt();
      int a=in.nextInt();
      int b=in.nextInt();
      int c=in.nextInt();
      int d=in.nextInt();
      int x=in.nextInt();
      int y=in.nextInt();
      int z=in.nextInt();

        int i1=n/a;
        int i2=m/b;
        int max=0;
 //      int i= Math.min(i1,i2);
//       int j=m/c;
//       int k=n/d;
       for(int i=0;i<=Math.min(i1,i2);i++){
           for(int j=0;j<=(m-i*b)/c;j++){
               for(int k=0;k<=(n-a*i)/d;k++){
                   int money=x*i+y*j+z*k;
                   if(max<money){
                       max=money;
                   }

               }
           }
       }
        System.out.println(max);
    }

}
