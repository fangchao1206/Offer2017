package fang.剑指offer;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fangchao05 on 2017/8/1.
 */
public class 大整数想乘法 {
    /**
     * @Description:未优化的大数相乘
     * @param a
     * @param b
     * @return a*b={a1*10^(n1/2)+a0}*{b1*10^(n2/2)+b0}
     */
    public static String Mutiply1(String a, String b)// 用字符串读入2个大整数
    {
        String result = "";
        if (a.length() == 1 || b.length() == 1)// 递归结束的条件
            //其中一个长度为1，另一个不一定
            result = "" + Long.valueOf(a) * Long.valueOf(b);
        else// 如果2个字符串的长度都 >= 2
        {
            //1.分割成  a1  a0  b1  b0
            int lengthA0 = a.length() / 2;
            int lengthA1=a.length()-lengthA0;
            String a1 = a.substring(0, lengthA1); // 截取前一半的字符串(较短的一半)
            String a0 = a.substring(lengthA1, a.length()); // 截取后一半的字符串

            int lengthB0 = b.length() / 2;
            int lengthB1=b.length()-lengthB0;
            String b1 = b.substring(0, lengthB1);
            String b0 = b.substring(lengthB1, b.length());
            // * a*b=
            // * (a1*b1)* 10^[(n1+n2)/2 ]
            // * +(a1*b0)*10^(n1/2)
            // * +(a0*b1)*10^(n2/2)
            // * +(a0*b0)
            //2.计算展开式中的乘法
            String a1b1 = Mutiply1(a1, b1);
            String a1b0 = Mutiply1(a1, b0);
            String a0b1 = Mutiply1(a0, b1);
            String a0b0 = Mutiply1(a0, b0);

            //3.模拟移位
            String resulta1b1 = a1b1;
            for (int i = 0; i < lengthA0+lengthB0; i++) {
                resulta1b1 += "0";
            }
            String resulta1b0 = a1b0;
            for (int i = 0; i <lengthA0; i++) {
                resulta1b0 += "0";
            }
            String resulta0b1 = a0b1;
            for (int i = 0; i < lengthB0; i++) {
                resulta0b1 += "0";
            }
            //4.大数相加
            result = add(resulta1b1, resulta1b0);
            result = add(result, resulta0b1);
            result = add(result, a0b0);
        }
        return result;
    }

    /**
     * @Describe_将表示数字的字符串从高位到低位的形式压入栈_并去除其中的空格
     * @param str
     * @return
     * @throws Exception
     */
    private static Stack<String> numSplit(String str) throws Exception {

        Stack<String> s = new Stack<String>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (' ' == c) {
                continue;
            }
            if (c >= '0' && c <= '9') {
                s.push(c + "");
            } else {
                throw new Exception("错误： 输入了非数字类型的字符！  ");
            }
        }
        return s;
    }

    /**
     * @Describe_求两个大数的和_加数和被加数以字符串的形式给出_计算的结果也以字符串的形式返回
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
    @SuppressWarnings("finally")
    public static String add(String a, String b) {
        Stack<String> sum = new Stack<String>();
        try {
            Stack<String> sA = numSplit(a);
            Stack<String> sB = numSplit(b);

            int tSum;// 表示两位的和
            boolean isCarry = false;// 是否有进位
            // 当两个栈都非空时，依次出栈，然后相加
            while (!sA.isEmpty() && !sB.isEmpty()) {
                tSum = Integer.valueOf((String) sA.pop())
                        + Integer.valueOf((String) sB.pop());
                if (isCarry) {
                    tSum++;
                    isCarry = false;// 将低位的进位状态消除掉，防止影响下次的使用
                }
                if (tSum >= 10) {
                    tSum -= 10;
                    isCarry = true;
                }
                sum.push("" + tSum);
            }
            Stack<String> temp = !sA.isEmpty() ? sA : sB;

            // 当其中一个为空时，对另一个非空的进行操作
            while (!temp.isEmpty()) {
                int t = Integer.valueOf((String) temp.pop());
                if (isCarry) {// 第一个isCarry为上面的残留
                    t++;
                    if (t >= 10) {
                        t -= 10;
                    } else {
                        isCarry = false;// 只有当上一次是true，且这一次没有进位时，才需要对isCarry进行修改
                    }
                }
                sum.push("" + t);
            }
            // 对最后一次相加的十位的数字进行判断
            if (isCarry) {
                sum.push("" + 1);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return stack2Str(sum);
        }

    }

    /**
     * @Describe_将一个栈中的数据从栈顶到栈底变成一个字符串
     * @param
     * @return
     */
    private static String stack2Str(Stack<String> s) {
        String str = "";
        while (!s.isEmpty()) {
            str += s.pop().toString();
        }
        return str;
    }
    /**
     * @Description拿BigInteger自身大数相乘来判断自身算法的正确与否
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {

            String aString=scan.next();
            String bString=scan.next();

            String result2=Mutiply1(aString, bString);


            System.out.println("计算结果：  "+result2);

        }

    }


}
