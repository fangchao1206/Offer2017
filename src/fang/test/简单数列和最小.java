package fang.test;

/**
 * 未完成
 */
public class 简单数列和最小 {
    public static void main(String[] args) {
        int a[]={1,3,7,9};
        int b[]={2,10,12};
        int result[][]=new int[4][3];

        int sum1=sum(a);
        int sum2=sum(b);
        int dif=Math.abs(sum1-sum2);
 int i1=0,j1=0;
        int q=dif;
        for(int i=0;i<a.length;i++){
        for(int j=0;j<b.length;j++){
            int d=Math.abs(a[i]-a[j]);
            int qq=Math.abs(d-dif);
            if(qq<q){
                  q=qq;
                 i1=i;
                 j1=j;
            }
        }

        }
        int t=a[i1];
        a[i1]=a[j1];
        a[j1]=t;




          sum1=sum(a);
          sum2=sum(b);
          dif=Math.abs(sum1-sum2);
           i1=0;j1=0;
          q=dif;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                int d=Math.abs(a[i]-a[j]);
                int qq=Math.abs(d-dif);
                if(qq<q){
                    q=qq;
                    i1=i;
                    j1=j;
                }
            }

        }
        int tt=a[i1];
        a[i1]=a[j1];
        a[j1]=t;
        System.out.println(sum(a)-sum(b));
    }

   static int sum(int[]data){
        int s=0;
        for(int i:data){
            s+=i;
        }
        return s;
    }
}
