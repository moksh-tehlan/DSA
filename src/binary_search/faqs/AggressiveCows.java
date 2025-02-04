package binary_search.faqs;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 4, 7, 10, 9};
        System.out.println(aggressiveCows(arr,4));
    }

    private static int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 1;
        int end = nums[nums.length-1]-nums[0];
        while(start <= end){
            int mid = start + (end-start)/2;
            boolean minimumWithMid = isPossible(nums,mid,k);

            if(minimumWithMid){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }

    private static boolean isPossible(int[] nums, int min,int k) {
        int lastStall = nums[0];
        int cows = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - lastStall >= min){
                cows++;
                lastStall = nums[i];
                if(cows == k)return true;
            }
        }
        return false;
    }
}
