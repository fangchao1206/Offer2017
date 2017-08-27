package DS.树;

public class 树的最大宽度  {

    static int btwidth(BinTreeTra.Node root) {
        int front = -1, rear = -1;
        int last = 0, level = 0;
        BinTreeTra.Node[] queue = new BinTreeTra.Node[100000];
        int [] L=new int[100000];//
        if (root == null) {
            return 0;
        }
        queue[++rear]=root;
        L[rear]=1;//第一个节点的层次是1
        BinTreeTra.Node p;
        while(front<rear){
            p=queue[++front];
            if(p.leftChild!=null){
                queue[++rear]=p.leftChild;
                L[rear]=level+2;//表示rear这个节点在第leve+2层因为 leve=0表示第一层

            }
            if(p.rightChild!=null){
                queue[++rear]=p.rightChild;
                L[rear]=level+2;
            }
            if(front==last){
                level++;
                last=rear;
            }
        }
        int n;//每层宽度
        int m=0;//最大宽度
        int i=0;//从0开始遍历L 只需一次即可

        for(int k=1;k<=level;k++){
            n=0;
            for(;L[i]==k;i++){
                n++;
            }
            if(n>m){
                m=n;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        BinTreeTra.Node root = BinTreeTra.init();
        System.out.println(btwidth(root));
    }
}