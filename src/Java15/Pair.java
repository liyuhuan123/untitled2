package Java15;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Pair implements Comparable<Pair> {
    public int n1;
    public int n2;
    public int sum;

    public Pair(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.sum = n1 + n2;
    }

    @Override
    public int compareTo(Pair o) {
        //this比other小，返回小于0；
        //this比other大，返回大于0；
        //this和other相等，返回0
        return this.sum - o.sum;
    }
    public class HeapExam{
        public List<List<Integer>> kSamllestPairs(int[] nums1, int[] nums2, int k){
            List<List<Integer>> result = new ArrayList<>();
            if(nums1.length == 0 || nums2.length == 0 || k <= 0){
                return result;
            }
            PriorityQueue<Pair> queue = new PriorityQueue<>();
            for(int i = 0;i < nums1.length;i++){
                for(int j = 0;j < nums2.length;j++){
                    queue.offer(new Pair(nums1[i],nums2[j]));
                }
            }
            for(int j = 0;j < k && !queue.isEmpty();j++){
                Pair cur = queue.poll();
                List<Integer> temp = new ArrayList<>();
                temp.add(cur.n1);
                temp.add(cur.n2);
                result.add(temp);
            }
            return result;
        }
    }
}
