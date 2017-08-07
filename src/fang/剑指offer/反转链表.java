package fang.剑指offer;

/**
 * Created by fangchao05 on 2017/8/7.
 */
public class 反转链表 {
    public static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode reverseList(ListNode head) {
            ListNode p=head;

            ListNode q=head.next,qn;

            while(q!=null){
                qn=q.next;
                q.next=p;
                p=q;
                q=qn;
            }
            head.next=null;
            return p;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        printList(head);
        head = reverseList(head);
        printList(head);
        //head = reverseList2(head);
        //printList(head);

    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
