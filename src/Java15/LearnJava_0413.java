package Java15;

import java.util.*;

//class Node {
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//}
public class LearnJava_0413 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], value + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) {
                return key;
            }
        }
        return -1;
    }

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int result = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                result++;
            }
        }
        return result;

    }
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String expected = scanner.next();
            String actual = scanner.next();
            expected = expected.toUpperCase();
            Set<Character> actualSet = new HashSet<>();
            for(char c : expected.toCharArray()){
                actualSet.add(c);
            }
            Set<Character> brokenBord = new HashSet<>();
            actual = actual.toUpperCase();
            for(char c : actual.toCharArray()){
                if(actualSet.contains(c)){
                    continue;
                }
                if(brokenBord.contains(c)){
                    continue;
                }
                System.out.println(c);
                brokenBord.add(c);
            }
        }
    }
}
