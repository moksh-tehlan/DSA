package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        // ans = ["((()))","(()())","(())()","()(())","()()()"]
        String curr = "";
        List<String> ans = new ArrayList<>();
        generateParentheses(curr,ans,n,n);
        printParentheses(ans);
    }

    static void generateParentheses(String curr, List<String> ans,int opening, int closing){
        // Base case: when we've used all opening and closing brackets
        if (opening == 0 && closing == 0) {
            ans.add(curr); // Add the completed valid combination
            return;
        }

        // If we have remaining opening brackets, we can always add an opening bracket
        if (opening > 0) {
            generateParentheses(curr + '(', ans, opening - 1, closing);
        }

        // We can add a closing bracket only if we have more closing brackets than opening
        // This ensures we don't close a bracket that hasn't been opened
        if (closing > opening) {
            generateParentheses(curr + ')', ans, opening, closing - 1);
        }
    }
    static void printParentheses(List<String> arr){
        for(String s : arr){
            System.out.println(s);
        }
    }
}
