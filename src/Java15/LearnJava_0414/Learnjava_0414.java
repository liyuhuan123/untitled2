package Java15.LearnJava_0414;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class TreeNode{
    int val;
    TreeNode root;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Learnjava_0414 {
//    public List<List<Integer>> kSmallestPairs
//            (int[] nums1, int[] nums2, int k) {
//
//    }
    public static int lastStoneWeight(int[] stones) {
//有一堆石头，每块石头的重量都是正整数。
//每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。
// 假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//如果 x == y，那么两块石头都会被完全粉碎；
//如果 x != y，那么重量为 x 的石头将会完全粉碎，
// 而重量为 y 的石头新重量为 y-x。
//最后，最多只会剩下一块石头。返回此石头的重量。
// 如果没有石头剩下，就返回 0。
        int length = stones.length;
        while(length > 1){
            Arrays.sort(stones);
            if(stones[length - 1] == stones[length - 2]){
                length = length - 2;
            }
            int temp = stones[length - 1];
            stones[length - 1] = 0;
            stones[length - 2] = temp - stones[length - 2];
            length--;
        }
        if(length == 1){
            return stones[0];
        }
        return 0;
    }
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean temp = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(!temp) {
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if ((cur.left != null && cur.right == null)||
                        (cur.left == null && cur.right == null)){
                    temp = true;
                }else if(cur.left == null && cur.right != null){
                    return false;
                }
            }else{
                if(cur.left == null && cur.right == null){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] stones = {1,4,2,5,6,9,7};
        System.out.println(lastStoneWeight(stones));

    }
}
