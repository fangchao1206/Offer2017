package fang.剑指offer;

import java.util.Scanner;

/**
 * Created by fangchao05 on 2017/8/1.
 */
public class 六一 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int hs[] = new int[h];

        for (int j = 0; j < h; j++) {
            hs[j] = sc.nextInt();
        }
        int w = sc.nextInt();
        int ws[] = new int[w];

        for (int j = 0; j < w; j++) {
            ws[j] = sc.nextInt();
        }
        sort(ws,0,ws.length-1);
        sort(hs,0,hs.length-1);
        int count =0;
        int j=0;
        for(int i=0;i<w;i++){
           for(;j<h;){
               if(ws[i]>=hs[j]){
                   count++;
                   j++;


               }
               break;
           }
        }



        System.out.println(count);
    }




    public  static void sort(int []s,int l,int r){
        if(l<r){
            int i=l;
            int j=r;
            int x=s[i];
            while(i<j){
                // 从右向左找第一个小于x的数
                while(i<j&&s[j]>x){//至少有一个是有等于的
                    j--;
                }
                s[i]=s[j];
                // 从左向右找第一个大于等于x的数
                while(i<j&&s[i]<=x){  //至少有一个是有等于的
                    i++;
                }
                s[j]=s[i];
            }
            s[i]=x;
            //System.out.println(l+"============"+r);
            sort(s,l,i-1);   //l  不是0
            sort(s,i+1,r);   //r 不是len-1
        }


    }
}

