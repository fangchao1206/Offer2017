package fang.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 运动员1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        List <Integer>data=new ArrayList<>();
        for(int x=0;x<n;x++){
            data.add(in.nextInt());
        }
       // int data[]={4,5,1,3,2};
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(data.get(j)>data.get(i)){
                    result[i]++;
                }
            }
        }
        for(int r:result){
            System.out.println(r);

        }
    }
}
