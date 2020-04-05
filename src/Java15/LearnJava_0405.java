package Java15;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class LearnJava_0405 {
    public static TreeNode build(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }
    //1.非递归实现先序遍历
    public static void preOrderByLoop(TreeNode root){
        //先准备一个栈，把根结点入栈，循环取栈顶元素同时出栈
        //并访问栈顶元素，判断当前节点的右子树是否为null
        //非空就入栈，判断当前节点的左子树是否为null，非空也入栈
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            System.out.print(top+" ");
            if(top.right != null){
                stack.push(top.right);
            }
            if(top.left != null){
                stack.push(top.left);
            }
        }
    }
    //2.非递归实现中序遍历
    public static void inOrderByLoop(TreeNode root){
        //1)先从root出发（还不能访问元素）向左找，路上遇到的元素纷纷入栈
        //一直找到左子树为null，暂时先不找了
        //2）到达最左侧元素之后，取栈顶元素同时出栈，并且访问这个元素
        //3）把刚才的栈顶元素的右子树作为起点，再循环往左找，路径上遇到的
        //元素依次入栈
        if (root == null){
            return;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(true){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val + " ");
            cur = top.right;
        }

    }
    //3.非递归实现后序遍历
    //1）创建一个cur变量，指向root，从cur出发循环往左找，路上遇到
    // 的非空结点都入栈
    //2）取出栈顶元素（不是pop而是peek）此时栈顶元素是否能访问还得进一步判断
    //a)如果栈顶元素没有右子树，说明该结点可以访问，访问加pop
    //b)如果栈顶元素的右子树已经 被访问过了，此时也可以访问
    //该结点，访问加pop
    //3)接下来从当前栈顶元素的右子树出发继续刚才的过程
    public static void postOrderByLoop(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        
    }


    public static void main(String[] args){
        TreeNode root = build();
        preOrderByLoop(root);
    }
}
