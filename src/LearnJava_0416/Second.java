package LearnJava_0416;

public class Second {
    public static class Node{
        int key;
        Node right;
        Node left;

        public Node(int key) {
            this.key = key;
        }
    }
    private Node root = null;
    //1.查找
    public Node Search(int key){
        Node cur = root;
        while(cur != null){
            if(key == cur.key){
                return cur;
            }else if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return null;
    }
    //2.插入
    public boolean insert(int key){
        if(root == null){
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node parent = null;
        while(cur != null){
            if(key == cur.key){
                return false;
            }else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        Node node = new Node(key);
        if(key < parent.key){
            parent.left = node;
        }else{
            parent.right = node;
        }
        return true;
    }
    //3.删除
    public boolean remove(int key){
        Node cur = root;
        Node parent = null;
        while(cur != null){
            if(key == cur.key){
                removeNode(parent,cur);
                return true;
            }else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        return false;
    }
         //a）待删除元素是父结点的左子树
        //      待删除元素左子树为空，右子树非空
        //b）待删除元素是父结点的右子树
        //      待删除元素的左子树为空，右子树非空
        // c）待删除元素是父结点左子树
        //       待删除元素左子树非空，右子树为空
        // d）待删除元素是父结点的右子树
        //       待删除元素左子树非空，右子树为空
        // e）待删除元素是父结点的左子树
        //        待删除元素左右子树均非空
        // f）待删除元素是父结点右子树
        //      待删除元素左右子树均非空
    public void removeNode(Node parent,Node cur){
        if(cur.left == null){
            if(cur == root){
                root = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else{
                parent.right = cur.right;
            }
        }else if(cur.right == null){
            if(cur == root){
                root = cur.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else{
                parent.right = cur.left;
            }
        }else{
            Node goatParent = cur;  // 替罪羊节点的父节点
            Node scapeGoat = cur.right; // 替罪羊节点
            while (scapeGoat.left != null) {
                goatParent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            cur.key = scapeGoat.key;
            if (scapeGoat == goatParent.left) {
                goatParent.left = scapeGoat.right;
            } else {
                goatParent.right = scapeGoat.right;
            }
        }
    }
    public void preOrder(Node root){
        if(root != null){
            System.out.print(root + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root + " ");
            inOrder(root.right);
        }
    }
    public static void main(String[] args){
        Second tree = new Second();
        tree.insert(9);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(3);
        tree.insert(6);
        tree.insert(8);
        System.out.println("先序遍历结果：");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println("中序遍历结果");
        tree.inOrder(tree.root);
        System.out.println();

        Node cur = tree.Search(100);
        System.out.println(cur);

        System.out.println("=================");

        tree.remove(5);
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
    }
}
