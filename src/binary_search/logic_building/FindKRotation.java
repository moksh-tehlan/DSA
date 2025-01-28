package binary_search.logic_building;

import java.util.ArrayList;
import java.util.Arrays;

public class FindKRotation {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3));
        System.out.println(findKRotation(arr));
    }

    private static int findKRotation(ArrayList<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;
        int min = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(start) <= arr.get(mid)) {
                if (arr.get(start) < arr.get(min)) {
                    min = start;
                }
                start = mid + 1;
            } else {
                if (arr.get(mid) < arr.get(min)) {
                    min = mid;
                }
                end = mid - 1;
            }
        }
        return min;
    }
}
