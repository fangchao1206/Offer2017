package fang.剑指Offer2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class 树的最低公共祖先50 {
    static void getPath(TreeNode root, TreeNode target, List<TreeNode> result ) {
        if (root == null) {
            return;
        }
        result.add(root);
        if (root != target) {
            List<TreeNode> childrens = root.children;
            for (TreeNode node : childrens) {
                getPath(node, target, result );
            }
        } else if (root == target) {
            System.out.println(result);

        }
        // 现场还原  这个if要有 要不然最后返回的result都是1
        if(!result.contains(target)){
            result.remove(result.size() - 1);
        }

    }

    static public TreeNode getLastCommonNode(List<TreeNode> p1, List<TreeNode> p2) {

        Iterator<TreeNode> ite1 = p1.iterator();
        Iterator<TreeNode> ite2 = p2.iterator();
        TreeNode last = null;
        while (ite1.hasNext() && ite2.hasNext()) {
            TreeNode t1 = ite1.next();
            TreeNode t2 = ite2.next();
            if (t1 == t2) {
                last = t1;
            }
        }
        return last;
    }

    /**
     * **
     * 找树中两个结点的最低公共祖先
     *
     * @param root 树的根结点
     * @param p1   结点1
     * @param p2   结点2
     * @return 公共结点，没有返回null
     */

    public static TreeNode getLastCommonParent(TreeNode root, TreeNode p1, TreeNode p2) {
        if (root == null || p1 == null || p2 == null) {
            return root;
        }

        final  List<List<TreeNode>>[] resdata = new List[1];
        resdata[0]=new ArrayList<>();



        List<TreeNode> path1 = new LinkedList<>();
        getPath(root, p1, path1 );
        List<TreeNode> path2 = new LinkedList<>();
        getPath(root, p2, path2 );
        /*//下面要根据这两个链表从头向下找最后一个相同的节点
        System.out.println(resdata.get(0) + "" + resdata.get(1));*/
         return getLastCommonNode(path1, path2);
    }

    public static void main(String[] args) {
        test01();
        System.out.println("==========");
        test02();
        System.out.println("==========");
        test03();
    }

    // 形状普通的树
    //             1
    //           /   \
    //         2      3
    //        /         \
    //      4            5
    //     / \        /  |  \
    //    6   7      8   9  10
    public static void test01() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n1.children.add(n2);
        n1.children.add(n3);

        n2.children.add(n4);

        n4.children.add(n6);
        n4.children.add(n7);

        n3.children.add(n5);

        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);

        System.out.println(getLastCommonParent(n1, n9, n8));
    }

    // 树退化成一个链表
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test02() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);

        System.out.println( getLastCommonParent(n1, n4, n5));
    }

    // 树退化成一个链表，一个结点不在树中
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test03() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);

        System.out.println(getLastCommonParent(n1, n5, n6));
    }

    interface Listener {
       void  getlist(List<TreeNode> data);

    }

    /**
     * 树的结点定义
     */
    private static class TreeNode {
        int val;

        List<TreeNode> children = new LinkedList<>();


        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
