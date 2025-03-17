package stackques.faqs;

import java.util.ArrayDeque;

public class LargestRectangle {
    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 1, 1, 1, 1};
        System.out.println(largestRectangleArea(heights));
    }

    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= (i == n ? -1 : heights[i])) {
                int element = stack.pop();
                int prevSmallest = stack.isEmpty() ? -1 : stack.peek();
                int breadth = i - prevSmallest - 1;
                int area = breadth * heights[element];
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
