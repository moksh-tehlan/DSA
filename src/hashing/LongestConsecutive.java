package hashing;

import java.util.HashSet;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] arr = new int[]{};
        System.out.println(longestConsecutive(arr));
    }
    static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longestSum = 0;

        for (int j : nums) {
            set.add(j);
        }
        for (int num : set) {
            if(!set.contains(num-1)){
                int curr = 0;
                int currNumber = num;
                while (set.contains(currNumber)) {
                    curr += 1;
                    currNumber++;
                }
                longestSum = Math.max(curr, longestSum);
            }
        }
        return longestSum;
    }
}
