package Java15;

import java.util.ArrayList;
import java.util.List;

public class YangHui {
    public List<List<Integer>>generate(int numRows){
        //杨辉三角的特点：
        //1.第一行固定，就是一个1
        //2.第二行也固定，就是两个1
        //3.第i行首尾元素都固定是1
        //4.第i行有i个元素
        //5.对第i行来说，第j列的值是第i-1行j-1列值加上i-1行j列值
        //例如，第二行第二列值是2，就是第一行第一列+第一行第二列
        if(numRows <= 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1){
            return result;
        }
        List<Integer> SecondLine = new ArrayList<>();
        SecondLine.add(1);
        SecondLine.add(1);
        result.add(SecondLine);
        if(numRows == 2){
            return result;
        }

        for(int i = 3;i <= numRows;i++){
            List<Integer> prevLine = result.get((i-1)-1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for(int j = 2;j < i;j++){
                int curNum = prevLine.get(j-1-1)+prevLine.get(j-1);
                curLine.add(curNum);
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;

    }
}
