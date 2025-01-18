package arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 1, 3, 2, 2};
        List<Integer> ans = majorityElementTwo(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    static List<Integer> majorityElementTwo(int[] arr) {
        int firstNumber = Integer.MIN_VALUE;
        int secondNumber = Integer.MIN_VALUE + 1;
        int firstFreq = 0;
        int secondFreq = 0;
        for (int i : arr) {
            if (firstFreq == 0 && secondNumber != i) {
                firstNumber = i;
                firstFreq = 1;
            } else if (secondFreq == 0 && firstNumber != i) {
                secondNumber = i;
                secondFreq = 1;
            } else if (i == firstNumber) {
                firstFreq++;
            } else if (i == secondNumber) {
                secondFreq++;
            } else {
                firstFreq--;
                secondFreq--;
            }
        }

        firstFreq = 0;
        secondFreq = 0;
        for (int i : arr) {
            if (i == firstNumber) {
                firstFreq++;
            } else if (i == secondNumber) {
                secondFreq++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        if (firstFreq > n / 3) ans.add(firstNumber);
        if (secondFreq > n / 3) ans.add(secondNumber);
        return ans;
    }
}
