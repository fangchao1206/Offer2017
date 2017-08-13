package fang.test;

public class 字符串反转 {
   static String [] inverse(String s){
        String arr[]=s.split(" ");
        int len=arr.length;

        for(int i=0,j=len-1;i<j;i++,j--){
            String t=arr[j];
            arr[j]=arr[i];
            arr[i]=t;
        }
        return  arr;
    }

    public static void main(String[] args) {
        String []arr=inverse("I am fangchao");
        for(String s:arr){
            System.out.print(s+" ");

        }

    }
}
