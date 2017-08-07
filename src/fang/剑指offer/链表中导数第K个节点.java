package fang.剑指offer;

/**
 * 为了实现只遍历链表一次就能找到倒数第k 个结点，我们可以定义两
 * 个指针。第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动；
 * 从第k 步开始，第二个指针也开始从链表的头指针
 * 开始遍历。由于两个指针的距离保持在k-1 ， 当第一个（走在前面的）指
 * 针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k 个结点。
 * Created by fangchao05 on 2017/8/7.
 */
public class 链表中导数第K个节点 {
    public static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode findKthToTail(ListNode head, int k) {

        // 输入的链表不能为空，并且k大于0
        if (k < 1 || head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i=0;i<k;i++){
            if(p2!=null){
                p2=p2.next;
            }else{
                return null;// 已经没有节点了，但是i还没有到达k-1说明k太大，链表中没有那么多的元素
            }

        }
        while (p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
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

        System.out.println(findKthToTail(head, 1).value); // 倒数第一个
        System.out.println(findKthToTail(head, 5).value); // 中间的一个
        System.out.println(findKthToTail(head, 9).value); // 倒数最后一个就是顺数第一个

        System.out.println(findKthToTail(head, 10));
    }
}
