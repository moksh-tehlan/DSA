package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 2, 10, 3};
        int[] ans = twoSum(arr,7);
        System.out.println(ans[0]+" "+ans[1]);
    }

    static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[]{-1,-1};

        // o(N^2)
//        for(int i = 0; i < n-1; i++){
//            int required = target - nums[i];
//            for(int j = i+1; j < n; j++){
//                if(nums[j] == required){
//                    ans[0] = i;
//                    ans[1] = j;
//                }
//            }
//        }
//        return ans;

        // let's optimise it for o(N) but it takes O(N) space using hash map
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i],i);
        }

        for(int i = 0; i < n ; i++){
            int required = target - nums[i];
            if(map.containsKey(required)){
                int index = map.get(required);
                if(index != i){
                    ans[0] = Math.min(i,index);
                    ans[1] = Math.max(i,index);
                }
            }
        }
        return ans;
    }
}
