package Java15;

import java.util.LinkedList;
import java.util.Queue;

public class Lt {
        private Queue<Integer> A = new LinkedList<>();
        private Queue<Integer> B = new LinkedList<>();

    /** Push element x onto stack. */
    public void push(int x) {
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if(empty()){
            return null;
        }
        while(A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        swapAB();
        return ret;
    }
    public void swapAB(){
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    /** Get the top element. */
    public Integer top() {
        if(empty()){
            return null;
        }
        if(A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        B.offer(ret);
        swapAB();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
