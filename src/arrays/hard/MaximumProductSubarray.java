package arrays.hard;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 3, 4, -4, -3};
        System.out.println(maxProduct(arr));
    }

    static int maxProduct(int[] nums) {
        return maxProductOptimise(nums);
    }

    static int maxProductBruteForce(int[] arr) {
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int currProduct = arr[i];
            for (int j = i + 1; j < n; j++) {
                max = Math.max(currProduct, max);
                currProduct *= arr[j];
            }
            max = Math.max(currProduct, max);
        }
        return max;
    }


    // we will start multiplying elements from left and right and we will check it with max
    static int maxProductOptimise(int[] arr) {
        int max=  Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            if(prefix == 0)prefix = 1;
            if(suffix == 0)suffix = 1;
            prefix *= arr[i];
            suffix *= arr[n-i-1];
            max = Math.max(max,Math.max(prefix,suffix));
        }
        return max;
    }
}
