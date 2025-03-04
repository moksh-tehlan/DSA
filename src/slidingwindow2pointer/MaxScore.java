package slidingwindow2pointer;

public class MaxScore {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 1, 8, 7, 1, 3};
        int k = 3;
        System.out.println(maxScore(arr, k));
    }

    private static int maxScore(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = n - 1;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int maxScore = sum;
        for(int i = k-1; i >= 0; i--){
            sum -= arr[i];
            sum += arr[r];
            r--;
            maxScore = Math.max(sum,maxScore);
        }
        return maxScore;
    }
}
