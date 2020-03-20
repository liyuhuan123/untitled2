package Java0319;
import static java.lang.Math.*;
public class Main {
    public static void main(String[] args){
        double x = 30;
        double y = 40;
        //静态导入的方式写起来更方便一些
        double result = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        double result1 = sqrt(pow(x,2)+pow(y,2));
        System.out.println(result);
        System.out.println(result1);
    }
}
