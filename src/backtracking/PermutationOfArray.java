package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfArray {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(numbers, 0, result);
        printPermutations(result);
    }

    /**
     * Recursively generates all permutations of the array.
     * The algorithm works by:
     * 1. Fixing one position at a time (starting from index 'l')
     * 2. Trying all possible elements at that position through swapping
     * 3. Recursively generating permutations for the remaining elements
     * <p>
     * For example, with array [1,2,3]:
     * - First iteration fixes each element at index 0: [1]--,[2]--,[3]--
     * - Second iteration fixes each remaining element at index 1
     * - Final iteration places the last remaining element
     */
    static void generatePermutations(List<Integer> arr, int l, List<List<Integer>> ans){
        // Base case: if we've fixed all positions, add the current permutation to the ans list
        if (l == arr.size()) {
            List<Integer> curr = new ArrayList<>(arr);
            ans.add(curr);
        }

        // Try each element as a possible candidate for the current position
        for (int i = l; i < arr.size(); i++) {
            // 1. Swap current element to the position we're fixing
            swap(arr, i, l);

            // 2. Recursively generate permutations for remaining elements
            generatePermutations(arr, l + 1,ans);

            // 3. Backtrack: restore array to its original state for next iteration
            swap(arr, i, l);
        }
    }

    static void swap(List<Integer> arr,int l,int r){
        if(l == r)return;
        int temp = arr.get(l);
        arr.set(l,arr.get(r));
        arr.set(r,temp);
    }

    static void printPermutations(List<List<Integer>> arr){
        for(List<Integer> list : arr){
            printArray(list);
        }
    }
    static void printArray(List<Integer> arr){
        for(int i : arr){
            System.out.print(i);
        }
        System.out.println();
    }
}
