package hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3,-3,1,1,1,4,2,-3};
        System.out.println(subarraySum(arr,3));
    }

    static int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0,1);
        int sum = 0;
        for(int i = 0;i < n; i++){
            sum += nums[i];
            int sumMinusK = sum-k;
            count += map.getOrDefault(sumMinusK,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
