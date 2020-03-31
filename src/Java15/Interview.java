package Java15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Interview {
    public boolean isSameTree(TreeNode p,TreeNode q){
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
//给定两个非空二叉树 s 和 t，
// 检验 s 中是否包含和 t 具有相同结构和节点值的子树
// s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
// s 也可以看做它自身的一棵子树。
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
         return ret||isSubtree(s.left,t)||isSubtree(s.right,t);
        }
    public int maxDepth(TreeNode root) {
//给定一个二叉树，找出其最大深度。
//二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//说明: 叶子节点是指没有子节点的节点。
        if(root == null){
            return 0;
        }
        int depth = 0;
        if(root.left == null &&root.right == null){
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (Math.max(leftDepth,rightDepth));
    }
    public boolean isBalanced(TreeNode root) {
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//本题中，一棵高度平衡二叉树定义为：
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
        if(root == null){
            return true;
        }
        if(root.left == null || root.right == null){
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(leftDepth - rightDepth > 1 || leftDepth-rightDepth < -1 ){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public boolean isSymmetric(TreeNode root) {
//给定一个二叉树，检查它是否是镜像对称的。
//例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
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
    //二叉树的层序遍历
    public void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.println(cur.val+" ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }

    }
