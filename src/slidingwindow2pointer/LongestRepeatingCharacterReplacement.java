package slidingwindow2pointer;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("BAABAABBBAAA", 2));
    }

    private static int characterReplacement(String s, int k) {
        int maxLength = 0;
        int i = 0, j = 0;
        int n = s.length();

        int[] hash = new int[26];
        Arrays.fill(hash, 0);
        int maxFreq = 0;

        while (j < n) {
            hash[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);
            if ((j - i + 1) - maxFreq > k) {
                hash[s.charAt(i) - 'A']--;
                i++;
            } else {
                maxLength = Math.max(j - i + 1, maxLength);
            }
            j++;
        }
        return maxLength;
    }
}
