package Java15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Learnjava_0402 {
//1.给定一个二叉树，返回它的 前序 遍历
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null){
        return list;
    }
    list.add(root.val);
    list.addAll(preorderTraversal(root.left));
    list.addAll(preorderTraversal(root.right));
    return list;

    }
    public List<Integer> inorderTraversal(TreeNode root) {
    //2.给定一个二叉树，返回它的中序遍历
    List<Integer> list = new ArrayList<>();
    if(root == null){
        return list;
    }
    list.addAll(inorderTraversal(root.left));
    list.add(root.val);
    list.addAll(inorderTraversal(root.right));
    return list;

    }
    public List<Integer> postorderTraversal(TreeNode root) {
    //3.给定一个二叉树，返回它的 后序 遍历。
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
//4.给定两个二叉树，编写一个函数来检验它们是否相同。
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
       if(p == null && q == null){
           return true;
       }
       if(p == null || q == null){
           return false;
       }
       if(p.val != q.val){
           return false;
       }
       return isSameTree(p.left,q.left) &&
               isSameTree(p.right,q.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
//5.给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t
// 具有相同结构和节点值的子树。s 的一个子树包括 s
// 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        boolean ret = false;
        if(s.val == t.val){
            ret = isSameTree(s,t);
        }
        return ret || isSubtree(s.left,t) ||
                isSubtree(s.right,t);

    }
    public int maxDepth(TreeNode root) {
//6.给定一个二叉树，找出其最大深度。
//二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (Math.max(leftDepth,rightDepth));

    }
    public boolean isBalanced(TreeNode root) {
//7.给定一个二叉树，判断它是否是高度平衡的二叉树
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int temp = leftDepth - rightDepth;
        if(temp > 1 || temp < -1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public boolean isSymmetric(TreeNode root) {
    //8.给定一个二叉树，检查它是否是镜像对称的
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    private boolean isMirror(TreeNode s,TreeNode t){

    if(s == null && t == null){
        return true;
    }
    if(s == null || t == null){
        return false;
    }
    if(s.val != t.val){
        return false;
    }
    return isMirror(s.left,t.right) && isMirror(s.right,t.left);
    }
    public void levelOrder(TreeNode root){
    //9.层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }

    }

}