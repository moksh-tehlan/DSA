package stackques.faqs;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 0, -1, 3, 5, 3, 6, 8};
        int[] ans = maxSlidingWindow(arr, 3);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    private static int[] maxSlidingWindow(int[] arr, int k) {
        int[] ans = new int[arr.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!deque.isEmpty() && deque.peekLast() <= i - k) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && arr[deque.peek()] <= arr[i]) {
                deque.pop();
            }
            deque.push(i);
            if (i >= k - 1) ans[j++] = (arr[deque.peekLast()]);
        }
        return ans;
    }
}
