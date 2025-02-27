package stackques.implementation;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParantheses {
    public static void main(String[] args) {
        System.out.println(isValid("(){}()]"));
    }

    private static boolean isValid(String str){
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : str.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else{
                if(stack.isEmpty())return false;
                if(stack.pop() != c)return false;
            }
        }
        return stack.isEmpty();
    }
}
