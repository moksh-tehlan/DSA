package stackques.faqs;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<Long> stack;
    private long min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        long value = (long) val;

        if (stack.isEmpty()) {
            min = value;
            stack.push(value);
        } else if (value >= min) {
            stack.push(value);
        } else {
            stack.push(2 * value - min);
            min = value;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long popped = stack.pop();

        if (popped < min) {
            min = 2 * min - popped;
        }
    }

    public int top() {

        long top = stack.peek();

        if (top < min) {
            return (int) min;
        } else {
            return (int) top;
        }
    }

    public int getMin() {
        return (int) min;
    }
}
