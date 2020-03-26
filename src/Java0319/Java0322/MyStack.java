package Java0319.Java0322;

public class MyStack {
    //管理一些int元素即可，也不考虑扩容问题
    private int[] array = new int[100];
    private int size = 0;//栈中存在多少个有效元素
    //入栈
    public void push(int x){
        array[size] = x;
        size++;
    }
    //出栈
    public int pop(){
        int ret = array[size-1];
        size--;
        return ret;
    }
    //取栈顶元素（最后进来的那个元素）
    public int peek(){
        return array[size-1];
    }
}
