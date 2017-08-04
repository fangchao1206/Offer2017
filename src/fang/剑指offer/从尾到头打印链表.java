package fang.剑指offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by fangchao05 on 2017/7/31.
 */
public class 从尾到头打印链表 {

  static  public class ListNode {
        int val;
        ListNode next = null;
      ListNode(   ) {

      }
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null&&listNode.next==null) {
            return new ArrayList<>();
        }
        Stack stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();

        while (!stack.empty()) {
            int i = (Integer) stack.pop();
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();

        root.val = 1;
        root.next = new ListNode();
        root.next.val = 2;
        root.next.next = new ListNode();
        root.next.next.val = 3;
        root.next.next.next = new ListNode();
        root.next.next.next.val = 4;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.val = 5;

    ArrayList <Integer>list=    printListFromTailToHead(root);
    for(int i:list){
        System.out.println(i);
    }

    }
}
