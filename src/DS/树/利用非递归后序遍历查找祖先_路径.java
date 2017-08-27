package DS.树;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import static DS.树.BinTreeTra.init;

/**
 * 后续遍历：找到x后 栈里面剩下的元素就是全部祖先也是路径
 */
public class 利用非递归后序遍历查找祖先_路径 {

    static List<BinTreeTra.Node> nodeList = null;
    private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        static void printS(Stack S) {
            Iterator<BinTreeTra.Node> iterator = S.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next().data + " ");
            }
        }
        /**
         * 寻找值为x（假设只有一个值为x的节点）的节点的所有祖先
         * @param root
         * @param x
         */
        static void search(BinTreeTra.Node root, int x) {
            Stack<BinTreeTra.Node> S = new Stack<BinTreeTra.Node>();
            BinTreeTra.Node p = root;
            BinTreeTra.Node r = null;

            while (p != null || S.size() > 0) {
                if (p != null) {
                    S.add(p);
                    p = p.leftChild;

                } else {
                    p = S.peek();
                    if (p.rightChild != null && p.rightChild != r) {
                        p = p.rightChild;
                        //下面这两句不要也可以
                        /*S.add(p);
                        p = p.leftChild;*/
                    } else {
                        p = S.pop();
                        //关键 找到x后答应栈中元素 即为祖先
                        if(p.data==x){
                            printS(S);
                            return;
                        }
                        //BinTreeTra.printNode(p);
                        r = p;
                        p = null;
                    }
                }
            }
        }

        public static void main(String[] args) {
            BinTreeTra.Node root =  init();
            search(root,16);

        }

}
