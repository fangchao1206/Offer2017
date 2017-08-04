package fang.剑指offer;

import fang.Thread.单例模式.MyObject_序列化;

/**
 * Created by fangchao05 on 2017/8/1.
 */
public class 最大乘积 {

    public static void main(String[] args) {
        int arr[] = {-1, -8, 3, 5, -7, 4, 9, 1, 2, 6, 8, 11, -4, -3};
        int maxNums[] = new int[3]; //小到大顺序
        int minNums[] = new int[2];
        int minu=0;
        int maxu=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                for (int j = 0; j < 2; j++) {
                    if (minNums[j] > arr[i]) {
                        minNums[j] = arr[i];
                        break;
                    }

                }

            } else {
                for (int j = 2; j >= 0; j--) {


                        if (maxNums[j] < arr[i]) {

                            maxNums[j] = arr[i];
                            break;
                        }


                }
            }
        }

        if (minNums[0] * minNums[1] > maxNums[0] * maxNums[1]) {
            System.out.println(minNums[0] * minNums[1] * maxNums[2]);
        } else {
            System.out.println(maxNums[0] * maxNums[1] * maxNums[2]);
        }

        Mycontainer mycontainer = new Mycontainer(3);
       // mycontainer.pushL(1);
       // mycontainer.pushL(2);

    }

    static class Mycontainer {
        int size;

        public Mycontainer(int size) {
            this.size = size;
        }

        int arr[] = new int[size];
        int top = 0;

        int pushL(int v) {

            if (top<size-1) {
                for (int i = top+1; i >= 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = v;
                return v;
            }else{

                return v;
            }
        }
    }

}

