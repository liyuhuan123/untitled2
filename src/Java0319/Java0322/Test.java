package Java0319.Java0322;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        System.out.println(func());
    }
    public static int func(){
        try{
            return 10;
        }finally{
            return 20;
        }
    }
}