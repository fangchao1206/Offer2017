package fang.剑指offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * Created by fangchao05 on 2017/7/31.
 */
public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        //2为空时 先将1全部入站   否则直接弹出
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {

                stack2.push(stack1.pop());
            }
        }

        // 如果弹出栈中还没有数据就抛出异常
        if (stack2.isEmpty()) {
            throw new RuntimeException("No more element.");
        }

        return stack2.pop();
    }
}
