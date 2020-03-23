package Java0319.Java0322;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        System.out.println(divide(10,0));
    }
    public static int divide(int x,int y){
        if(y == 0){
            throw new ArithmeticException("抛出除0异常");
        }
        return x/y;
    }
}