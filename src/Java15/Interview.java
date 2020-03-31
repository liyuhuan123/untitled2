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
    public List<Integer> preorderTraversal(TreeNode root) {
        //给定一个二叉树，返回它的 前序 遍历。
        List<Integer> result = new ArrayList<>();
        if(root == null){
            //空树返回一个空的List（元素个数为0，但是不是null）
            return result;
        }
        //访问根结点
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;


    }
}
