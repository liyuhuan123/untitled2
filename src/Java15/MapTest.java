package Java15;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"PHP");
        //key重复
        map.put(1,"Python");
        map.put(3,"Java");
        map.put(2,"c++");
        System.out.println(map);
        //根据key取得value
        System.out.println(map.get(2));
        System.out.println(map.get(99));
        for(Integer key:map.keySet()){
            System.out.println(key);
        }
        for(String value:map.values()){
            System.out.println(value);
        }
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+"="+ entry.getValue());
        }
    }
}
