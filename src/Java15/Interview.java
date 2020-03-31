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
    public List<Integer> postorderTraversal(TreeNode root) {
//给定一个二叉树，返回它的后序遍历
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return null;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }
}
