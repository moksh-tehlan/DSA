package arrays.medium;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
//        int[] nums = new int[]{-94,-975,-512,-437,617,-188,-625,-184,-639,-171,-492,827,-257,-346,-928,-611,-871,-219,-967,-310,719,-765,-330,-852,-415,-769,-347,-361,-431,-101,-385,519,-376,-396,200,-557,-662,141,622,-520,-898,-311,-957,-979,-66,-196,-943,710,-407,148,-638,76,791,-667,-961,-661,-792,-824,-547,-919,-258,-445,-779,-81,-573,-343,-301,376,-879,-162,-703,-594,-768,-489,-461};
        int[] nums = new int[]{2, -2, 0, 3, -3, 5};
//        what if array is sorted ? -3 -2 0 2 3 5
        List<List<Integer>> ans = threeSumImproved(nums);
        ans.sort((a,b)->{
            if(a.get(0) - b.get(0) != 0){
                return a.get(0) - b.get(0);
            }else if(a.get(1) - b.get(1) != 0){
                return a.get(1) - b.get(1);
            }
            return a.get(2) - b.get(2);
        });
        for(List<Integer> arr : ans){
            for(Integer i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> threeSumImproved(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = n-1;
            while(l < r){
                int sum = nums[l]+nums[r]+nums[i];
                if(sum == 0){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[l]);
                    arr.add(nums[r]);
                    arr.add(nums[i]);
                    ans.add(arr);
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                    while(r > l && nums[r] == nums[r+1]){
                        r--;
                    }
                }else if(sum > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ans;
    }
    static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i],i);
        }

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n;j++){
                int required = -nums[i] - nums[j];
                if(map.containsKey(required)){
                    int index = map.get(required);
                    if(index != i && i != j && index != j){
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[index]);
                        Collections.sort(arr);
                        if(!ans.contains(arr)){
                            ans.add(arr);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
