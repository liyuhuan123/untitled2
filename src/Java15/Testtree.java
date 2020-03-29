package Java15;

class Node{
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class Testtree {
    public static Node build(){
        //手动把一棵树构造出来
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;
        return a;
    }

    //先序遍历
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    //后序遍历
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    //写一个方法，求二叉树中结点的个数
    //采用后序遍历的方式
    public static int size(Node root) {
        if(root==null){
            return 0;
        }
        //访问根结点，此处的访问操作应该是计数器+1
        //体会递归“拆分问题”的过程
        //整个树结点个数= 根结点个数（1）+左子树节点的个数+右子树节点的额个数
        return 1+size(root.left)+size(root.right);
        }

        //求二叉树中叶子节点的个数
        //还是要遍历树，并且拆分问题
        //求root叶子结点的个数= root.left叶子结点个数+root.right的叶子结点个数
        public static int leafSize(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return leafSize(root.left)+leafSize(root.right);

        }

        //求二叉树第k层节点的个数
        //如果k<1只能是空树，直接返回0
        //如果k == 1求根结点的个数，直接返回1
        //k层结点的个数= 左子树的k-1层结点个数+右子树的k-1层结点个数
    public static int klevelsize(Node root,int k){
        if(k < 1 || root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return klevelsize(root.left,k-1)
                +klevelsize(root.right,k-1);
    }

    //在二叉树中查找指定元素
    //如果存在就返回该结点的引用，如果不存在，返回null
    Node find(Node root,char toFind){
        if(root == null){
            return null;
        }
        if(root.val == toFind){
            return root;
        }
        Node result = find(root.left,toFind);
        if(result != null){
            return result;
        }
        return find(root.right,toFind);
    }



    public static void main(String[] args){
        Node root = build();
        System.out.println("先序遍历：");
        preOrder(root);
        System.out.println();
        System.out.println("中序遍历：");
        inOrder(root);
        System.out.println();
        System.out.println("后序遍历：");
        postOrder(root);
        System.out.println();
        
    }

}
