package stackques.monotonicstack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] ast = new int[]{-517, 860, 740, 738, 775, -207, 924, -966, -141, 738, -912, -186, 422, 317, -644, 595, 357, 528, 914};
        int[] ans = asteroidCollision(ast);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i : asteroids) {
            if (i > 0) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(i) > stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == Math.abs(i)) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(i);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (Integer i : stack) {
            ans.add(0, i);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
