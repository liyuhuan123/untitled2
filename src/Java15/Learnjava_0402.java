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
public class Learnjava_0402{
    public boolean iscompleteTree(TreeNode root){
        //判断一个树是否是完全二叉树
        //针对这个树进行层序遍历
        if(root == null){
            return true;
        }
        boolean isSecondstep = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            //针对当当前节点进行访问（判断是否符合完全二叉树的要求）
            if(!isSecondstep){
                //这是第一阶段
                if(cur.left != null &&cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left == null && cur.right != null){
                    //当前第一阶段中某个节点只有右子树，没有左子树
                    //一定不是完全二叉树
                    return false;
                }else if(cur.left != null && cur.right == null){
                    //切换到第二阶段
                    isSecondstep = true;
                    queue.offer(cur.left);
                }else{
                    //左右子树都为空，也切换到第二阶段
                    isSecondstep = true;
                }
            }else{
                //这是第二阶段
                //要求第二阶段任何一个人节点都必须没有子树
                //只要找到某个节点带子树，就说明找到了反例
                if(cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        return true;
    }

}