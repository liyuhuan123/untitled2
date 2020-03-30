package Java15;

import java.util.Stack;

public class Lt {
    /** Initialize your data structure here. */
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        //1.先把B中的元素都倒腾到A里
        while(!B.isEmpty()){
            int ret = B.pop();
            A.push(ret);
        }
        A.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public Integer pop() {
        while(empty()){
            return null;
        }
        while(!A.isEmpty()){
            int ret = A.pop();
            B.push(ret);
        }
        return B.pop();

    }

    /** Get the front element. */
    public Integer peek() {
        while(empty()){
            return null;
        }
        while(!A.isEmpty()){
            int ret = A.pop();
            B.push(ret);
        }
        return B.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return A.isEmpty()&&B.isEmpty();

    }
}
