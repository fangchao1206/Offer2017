package fang.Thread.Lock.Condition;

/**
 * Created by fangchao05 on 2017/7/26.
 */
public class Cas {
    public static void main(String[] args) {

    }
    public final int getAndIncrement(boolean b) {

             while(b){//写成true可以 写false 或b 会编译错误b(报 缺少返回语句)
                 if(false){
                     return 1;
                 }
             }
        return 0;
    }
}
