package fang.剑指offer;

import java.util.Stack;

/**
 * Created by fangchao05 on 2017/8/7.
 */
public class 栈min函数 {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到校的最小元素的min函数。
     * 在该栈中，调用pop、push 及min的时间复杂度都是0(1)
     *
     * @param <T> 泛型参数
     */
    public static class StackWithMin<T extends Comparable> {
        // 数据栈，用于存放插入的数据
        private Stack<T> dataStack;
        // 最小数 栈，存放数据栈中最小的数
        private Stack<T> minStack;

        // 构造函数
        public StackWithMin() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();

        }

        /**
         * 出栈方法
         *
         * @return 栈顶元素
         */
        public T pop() {
            // 如果栈已经为空，再出栈抛出异常
            if (dataStack.isEmpty()) {
                throw new RuntimeException("The stack is already empty");
            }
            if (dataStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            return dataStack.pop();
        }

        /**
         * 元素入栈
         *
         * @param t 入栈的元素
         */
        public void push(T t) {
            // 如果入栈的元素为空就抛出异常
            if (t == null) {
                throw new RuntimeException("Element can be null");
            }

            dataStack.push(t);
            if (minStack.isEmpty()) {
                minStack.push(t);
            } else if (t.compareTo(minStack.peek()) < 0) {
                minStack.push(t);
            }

        }

        /**
         * 获取栈中的最小元素
         *
         * @return 栈中的最小元素
         */
        public T min() {
            // 如果最小数公位置栈已经为空（数据栈中已经没有数据了），则抛出异常
            if (minStack.isEmpty()) {
                throw new RuntimeException("No element in stack.");
            }

            // 获取数据栈中的最小元素，并且返回结果
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }
}
