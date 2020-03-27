package Java15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args){
        List<String> courses = new ArrayList<String>();
        courses.add("c语言");
        courses.add("javaSE");
        courses.add("iava Web");
        courses.add("java EE");
        //和数组一样，允许重复添加元素
        courses.add("javaSE");
        //按照添加顺序打印
        System.out.println(courses);
        //类似数组下标的方式访问
        System.out.println(courses.get(0));
        System.out.println(courses);
        courses.set(0,"java数据结构");
        System.out.println(courses);
        //截取部分[1,3)
        List<String> subCourses = courses.subList(1,3);
        System.out.println(subCourses);
        //重新构造
        List<String> courses2 = new ArrayList<String>(courses);
        System.out.println(courses2);
        List<String> courses3 = new ArrayList<String>(courses2);
        System.out.println(courses3);
        //引用的转换
        ArrayList<String> courses4 = (ArrayList<String>)courses2;
        System.out.println(courses4);
       // LinkedList<String> courses5 = (LinkedList<String>)courses3;
        //System.out.println(courses5);
    }
}
