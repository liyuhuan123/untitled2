package LearnJava_0416;

import java.util.*;

public class Homework {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (!map.containsValue(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                }else{
                    return false;
                }
            }else{
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
