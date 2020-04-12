package Java15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("java");
        //判断某个值是否存在
        System.out.println(set.contains("world"));
        //删除某个值
        set.remove("world");
        System.out.println(set.contains("world"));
        //遍历打印set
        System.out.println(set);
        System.out.println("============");
        //如果想要循环遍历set中的元素，就要使用迭代器了，
        //迭代器的泛型参数，要和集合类中保存的元素参数一致
        //集合类内部自己实现自己版本的迭代器类，不同的集合类，内部的迭代器类型不同
        //迭代方式也不同（迭代器的实现细节也不同）
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
