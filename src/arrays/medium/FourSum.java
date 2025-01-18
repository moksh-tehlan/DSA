package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
//        int[] nums = {1, -2, 3, 5, 7, 9};
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> ans = fourSum(nums,-294967296);
        ans.sort((a,b)->{
            if(a.get(0) - b.get(0) != 0){
                return a.get(0) - b.get(0);
            }else if(a.get(1) - b.get(1) != 0){
                return a.get(1) - b.get(1);
            }
            return a.get(2) - b.get(2);
        });
        System.out.println(ans.size());
        for(List<Integer> arr : ans){
            for(Integer i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> arr = new ArrayList<>();

        for(int i = 0; i < n-1; i++){
            if(i > 0 && nums[i] == nums[i-1])continue;
            for(int j = i+1; j < n; j++){
                if(j > i+1 && nums[j] == nums[j-1])continue;
                int left = j+1;
                int right = n-1;
                while(left < right){
                    long sum = (long)nums[i]+(long)nums[j]+(long)nums[left]+(long)nums[right];
                    if(sum < target){
                        left++;
                    }else if(sum > target){
                        right--;
                    }else{
                        arr.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1])left++;
                        while(right > left && nums[right] == nums[right+1])right--;
                    }
                }
            }
        }
        return arr;
    }
}
