package stackques.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = nextLargerElement(new int[]{1, 3, 2, 4});
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static int[] nextLargerElement(int[] arr) {
        int[] ans = new int[arr.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return ans;
    }
}
