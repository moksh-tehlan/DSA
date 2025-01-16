package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 3, 1, 2};
        ArrayList<Integer> ans = leaders(arr);
        for (Integer i : ans) {
            System.out.print(i + " ");
        }
    }

    static ArrayList<Integer> leaders(int[] arr) {
        int greater = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if(arr[i] > greater){
                ans.add(arr[i]);
                greater = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
