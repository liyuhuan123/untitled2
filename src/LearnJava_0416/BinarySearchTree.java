package LearnJava_0416;

public class BinarySearchTree {
    public static class Node{
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }
    private Node root = null;
    //1.在搜索树中查找key
    public Node search(int key){
        Node cur = root;
        while(cur != null){
            if(key == cur.key){
                return cur;
            }else if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.left;
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
            }else if(key > cur.key){
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
    //3.删除操作
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
            }else if(cur == parent.right){
                parent.right = cur.left;
            }
        }else{
            Node goatParent = cur;
            Node goat = cur.right;
            while(goat.left != null){
                goatParent = goat;
                goat = goat.left;
            }
            cur.key = goat.key;
            if(goat == goatParent.left){
                goatParent.left = goat.right;
            }else{
                goatParent.right = goat.right;
            }
        }
    }
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        int[] keys = {9,5,2,7,3,6,8};
        for(int key : keys){
            System.out.println(tree.insert(key));
        }
        System.out.println("插入重复数据");
        System.out.println(tree.insert(7));
        System.out.println("前序遍历");
        preOrder(tree.root);
        System.out.println("中序遍历");
        inOrder(tree.root);
        System.out.println(tree.search(7).key);
        System.out.println(tree.search(8).key);
        System.out.println(tree.search(5).key);
    }
    public static void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }
    public static void preOrder(Node node){
        if(node != null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
