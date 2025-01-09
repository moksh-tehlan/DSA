package backtracking;

import java.util.ArrayList;
import java.util.List;

public class ArraySubsequence {
    public static void main(String[] args) {


        List<Integer> curr = new ArrayList<>();
        int[] given = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        subsequenceHelper(given,curr,ans,0);
        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }

    static void subsequenceHelper(int[] arr, List<Integer> curr,List<List<Integer>> ans,int idx){
        ans.add(new ArrayList<>(curr));
        for(int i = idx; i < arr.length; i++){
            curr.add(arr[i]);
            subsequenceHelper(arr,curr,ans,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
