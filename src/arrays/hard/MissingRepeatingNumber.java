package arrays.hard;

public class MissingRepeatingNumber {
    public static void main(String[] args) {
//        sum of 7 digits -> 29
//        curr sum of 6 digits -> 31
        // normal series -> 1,2,3,4,5,6,7
        // fake series ->   1,2,3,7,5,6,7
        int[] ques = new int[]{1, 2, 3, 6, 7, 5, 7};
        int[] ans = findMissingRepeatingNumbers(ques);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    static int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        int naturalSum = (n * (n + 1)) / 2;
        int naturalSqSum = (n * (n + 1) * (2 * n + 1)) / 6;

        long fakeSum = 0;
        long fakeSqSum = 0;
        for (int i : nums) {
            fakeSum += i;
            fakeSqSum += (long) i * (long) i;
        }

        // eq 1
        long val1 =  fakeSum-naturalSum;
        long val2 =  fakeSqSum-naturalSqSum;

        // eq 2
        val2 = val2/val1;

        // now add eq 1 and 2
        long x = (val2 + val1) / 2;
        long y = val2 - x;
        ans[0] = (int)x;
        ans[1] = (int)y;
        return ans;
    }
}
