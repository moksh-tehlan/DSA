package arrays.medium;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, -3, -5, -2, -7, -4};
        System.out.println(maxSubArray(arr));
    }

    static int maxSubArray(int[] nums) {
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        for (int num : nums) {
            cs += num;
            ms = Math.max(cs, ms);
            if (cs <= 0) {
                cs = 0;
            }
        }
        return ms;
    }
}
