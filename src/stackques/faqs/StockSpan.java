package stackques.faqs;

import java.util.ArrayDeque;

public class StockSpan {
    public static void main(String[] args) {
        int[] ans = stockSpan(new int[]{120, 100, 60, 80, 90, 110, 115},7);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }

    private static int[] stockSpan(int[] arr, int n) {
        int[] ans = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            int currentSpan = 1;
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                int index = stack.pop();

                currentSpan += ans[index];
            }

            stack.push(i);
            ans[i] = currentSpan;
        }
        return ans;
    }
}
