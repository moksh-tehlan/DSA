package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = new int[]{-3, 2, 1};
        System.out.println(longestSubarray(arr,6));
    }

    static int longestSubarray(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];

            if(currSum == k){
                count = Math.max(count,i+1);
            }
            if(map.containsKey(currSum-k)){
                int length = i - map.get(currSum-k);
                count = Math.max(count,length);
            }else{
                map.put(currSum,i);
            }
        }
        return count;
    }
}
