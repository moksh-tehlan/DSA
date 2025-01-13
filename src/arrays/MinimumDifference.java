package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumDifference {
    public static void main(String[] args) {
        int[] arr = {12,9,8,2,11,5,4,5};
        List<List<Integer>> ans = minimumDifferent(arr);
        for (List<Integer> pair : ans) {
            System.out.println(pair);
        }
    }

    static List<List<Integer>> minimumDifferent(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        int minDifference = Integer.MAX_VALUE;
        for(int i = 1 ; i < arr.length; i++){
            minDifference = Math.min(arr[i]-arr[i-1],minDifference);
        }

        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i-1] == minDifference){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}
