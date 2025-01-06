package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SmartKeypadProblem {
    public static void main(String[] args) {
        String digits = "23";
        HashMap<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        String curr = "";
        int i = 0;
        smartKeypadProblemHelper(digits,i,curr,phoneMap,ans);
    }

    static void smartKeypadProblemHelper(String digits, int i, String curr, HashMap<Character, String> map, List<String> ans) {
        if (i >= digits.length()) {
            ans.add(curr);
            return;
        }

        String keypadString = map.getOrDefault(digits.charAt(i),"");
        for(int j = 0; j < keypadString.length(); j++){
            smartKeypadProblemHelper(digits,i+1,curr+keypadString.charAt(j),map,ans);
        }
    }
}
