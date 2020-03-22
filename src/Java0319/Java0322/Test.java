package Java0319.Java0322;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        Student[] student = new Student[]{
            new Student("张三",95),
            new Student("李四",96),
            new Student("王五",97),
            new Student("赵六",93),
        };
        Arrays.sort(student);
        System.out.println(Arrays.toString(student));
    }
}