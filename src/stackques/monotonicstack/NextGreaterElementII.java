package stackques.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] ans = nextGreaterElements(new int[]{1});
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    private static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        int auxN = 2 * n;

        for (int i = auxN - 1; i >= 0; i--) {
            int index = i % n;
            while (!stack.isEmpty() && stack.peek() <= arr[index]) {
                stack.pop();
            }
            if(i < n)ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[index]);
        }
        return ans;
    }
}
