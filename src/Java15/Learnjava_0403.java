package Java15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Learnjava_0403 {
    //1.输入两个整数序列，第一个序列表示栈的压入顺序，
    // 请判断第二个序列是否可能为该栈的弹出顺序。
    // 假设压入栈的所有数字均不相等。
    // 例如序列1,2,3,4,5是某栈的压入顺序，
    // 序列4,5,3,2,1是该压栈序列对应的一个弹出序列
    // ，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0 ||
                pushA.length != popA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0;i < pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[j]){
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    //2.给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
    // 判断二者是否相等，并返回结果。 # 代表退格字符
    public boolean backspaceCompare(String S, String T) {
        return handle(S).equals(handle(T));
    }
    private String handle(String x){
        Stack<Character> stack = new Stack<>();
        char[] arr = x.toCharArray();
        for(int i = 0;i < arr.length;i++){
            if(arr[i] != '#'){
                stack.push(arr[i]);
            }else if(arr[i] == '#' && (!stack.isEmpty())){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
    public ArrayList<Integer> asylum(int[][] ope) {
        //有家动物收容所只收留猫和狗，但有特殊的收养规则，
        // 收养人有两种收养方式，
        // 第一种为直接收养所有动物中最早进入收容所的，
        // 第二种为选择收养的动物类型（猫或狗），
        // 并收养该种动物中最早进入收容所的。
        //给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)
        // 代表所有事件。若第一个元素为1，
        // 则代表有动物进入收容所，第二个元素为动物的编号，
        // 正数代表狗，负数代表猫；若第一个元素为2，则代表有人收养动物，
        // 第二个元素若为0，则采取第一种收养方式，若为1，
        // 则指定收养狗，若为-1则指定收养猫。请按顺序返回收养的序列。
        // 若出现不合法的操作
        // 即没有可以符合领养要求的动物，则将这次领养操作忽略
        Queue<Integer> cat = new LinkedList<>();
        Queue<Integer> dog = new LinkedList<>();
        Queue<Integer> complete = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < ope.length;i++){
            if(ope[i][0] == 1){
                //有动物进入收容所
                if(ope[i][1] > 0){
                    dog.offer(ope[i][1]);
                }else if(ope[i][1] < 0){
                    cat.offer(ope[i][1]);
                }
                complete.offer(ope[i][1]);
            }else if(ope[i][0] == 2){
                //有人收养动物
                if(ope[i][1] == 0 && !complete.isEmpty()){
                    Integer temp1 = complete.poll();
                    array.add(temp1);
                    if(temp1 < 0){
                        cat.poll();
                    }else if(temp1 >0){
                        dog.poll();
                    }
                }else if(ope[i][1] == 1 && !dog.isEmpty()){
                    Integer temp2 = dog.poll();
                    array.add(temp2);
                    complete.remove(temp2);
                }else if(ope[i][1] == -1 && !cat.isEmpty()){
                    Integer temp3 = cat.poll();
                    array.add(temp3);
                    complete.remove(temp3);
                }
            }
        }
        return array;
    }
}
