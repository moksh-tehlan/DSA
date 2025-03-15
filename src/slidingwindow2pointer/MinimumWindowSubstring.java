package slidingwindow2pointer;

import java.util.Arrays;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

    }

    private static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int l = 0, r = 0;
        int[] hash = new int[256];
        int sIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        Arrays.fill(hash, 0);

        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        while (r < n) {
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;

            while (count == m) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }

                l++;
            }

            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLength);
    }
}
