package slidingwindow2pointer;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubstring {
    public static void main(String[] args) {
        String s = "aaabbbccc";
        System.out.println(longestNonRepeatingSubstring(s));
    }

    private static int longestNonRepeatingSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int n = s.length();
        int maxLength = Integer.MIN_VALUE;
        while (r < n) {
            char currCharacter = s.charAt(r);
            if (map.containsKey(currCharacter) && map.get(currCharacter) >= l) {
                l = map.get(currCharacter)+1;
            }
            map.put(currCharacter, r);
            int currLength = r - l + 1;
            maxLength = Math.max(maxLength, currLength);
            r++;
        }
        return maxLength;
    }
}
