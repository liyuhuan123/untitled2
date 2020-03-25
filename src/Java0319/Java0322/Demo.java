package Java0319.Java0322;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Demo {
    public static void main(String[] args){
        Collection<String> list = new ArrayList<String>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("我");
        list.add("爱");
        list.add("java");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        for(String s : list){
            System.out.println(s);
        }
        list.remove("爱");
        for(String s : list){
            System.out.println(s);
        }
        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
