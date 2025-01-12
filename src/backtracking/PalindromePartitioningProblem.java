package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningProblem {
    public static void main(String[] args) {
        List<List<String>> ans = palindromeSplitter("abbaca");
        for (List<String> partition : ans) {
            System.out.println(partition);
        }
    }

    static List<List<String>> palindromeSplitter(String s){
        List<List<String>> ans = new ArrayList<>();
        backtracking(s,new ArrayList<>(),ans,0);
        return ans;
    }

    static void backtracking(String s , List<String> curr, List<List<String>> ans ,int idx){
        if(idx >= s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s,idx,i)){
                curr.add(s.substring(idx,i+1));
                backtracking(s,curr,ans,i+1);
                curr.remove(curr.size()-1);
            }
        }
    }

    static boolean isPalindrome(String s , int l ,int r ){
        while (l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
