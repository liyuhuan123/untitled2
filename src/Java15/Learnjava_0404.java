package Java15;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Learnjava_0404 {
    //1.判断一棵树是否是完全二叉树
    public boolean isCompleteTree(TreeNode root){
        //针对一个完全二叉树，进行层序遍历的时候，会出现两种阶段
        //1）任何一个结点，一定有两颗子树
        //当遇到某个结点只有左子树或者没有子树的时候，就切换到第二阶段
        //如果遇到某个结点只有右子树，那么这棵树肯定不是完全二叉树
        //2)任何一个人结点，一定没有子树
        boolean temp = false;
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(!temp){
                if(cur.left != null && cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left != null ||
                        (cur.left == null && cur.right == null)){
                    temp = true;
                }else if(cur.left == null && cur.right != null){
                    return false;
                }
            }else{
                if(cur.left != null || cur.right != null){
                    return true;
                }
            }
        }
        return true;
    }

}
