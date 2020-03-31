package Java15;

import java.util.ArrayList;
import java.util.List;
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Interview {
    //给定两个二叉树，编写一个函数来检验它们是否相同。
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null && p == null){
            return true;
        }
        if(q == null || p == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }else{
            return isSameTree(p.left,q.left)&&
                    isSameTree(p.right,q.right);
        }
    }
}
