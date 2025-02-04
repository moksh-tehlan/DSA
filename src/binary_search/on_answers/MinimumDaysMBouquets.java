package binary_search.on_answers;

public class MinimumDaysMBouquets {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 7, 7, 7, 13, 11, 12, 7};
        System.out.println(roseGarden(arr.length, arr, 3, 2));
    }

    private static int roseGarden(int n, int[] nums, int k, int m) {
        int start = 0;
        int end = -1;

        for (int i : nums) {
            end = Math.max(end, i);
        }

        int ans = -1;  // Initialize to -1 instead of Integer.MAX_VALUE

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long formedBoque = boqueCanBeFormedWithDays(nums, k, mid);
            if (formedBoque >= m) {  // Changed condition to >=
                ans = mid;  // Store the current valid answer
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static long boqueCanBeFormedWithDays(int[] arr, int k, int days) {
        long bouque = 0;
        long curr = 0;
        for (int i : arr) {
            if (i <= days) {
                curr++;
            } else {
                curr = 0;
            }
            if (curr == k) {
                bouque++;
                curr = 0;

            }
        }
        return bouque;
    }
}
