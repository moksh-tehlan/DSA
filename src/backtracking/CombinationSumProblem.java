package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumProblem {
    public static void main(String[] args) {
        int[] arr = {8,1,3,7,2,1,5};
        List<List<Integer>> list = combinationSumProblem(arr, 12);
        for (List<Integer> combination : list) {
            System.out.println(combination);
        }
        
    }

    static List<List<Integer>> combinationSumProblem(int[] arr,int sum){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(arr,ans,new ArrayList<>(),sum,0);
        return ans;
    }

    static void backtrack(int[] arr, List<List<Integer>> ans, List<Integer> curr, int sumLeft,int idx){
        if(sumLeft == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (sumLeft < 0) {
            return;
        }

        for(int i = idx; i < arr.length; i++ ){
            if(i > idx && arr[i] == arr[i-1])continue;
            curr.add(arr[i]);
            backtrack(arr,ans,curr,sumLeft-arr[i],i+1);
            curr.remove(curr.size()-1);
        }
    }

}
