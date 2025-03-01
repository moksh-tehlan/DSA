package stackques.faqs;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> stack;
    long min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        if(stack.isEmpty()){
            min = val;
            stack.push(val);
        }else if(val > min){
            stack.push(val);
        }else{
            stack.push((int)(2*val - min));
            min = val;
        }
    }

    public void pop() {
        int popped = stack.pop();
        if (popped < min) {
            min = 2 * min - popped;
        }
    }

    public int top() {
        int top = stack.peek();
        return Math.max(top,(int) min);
    }

    public int getMin() {
        return (int) min;
    }
}
