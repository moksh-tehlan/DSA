package binary_search.logic_building;

import java.util.ArrayList;

public class SearchInRotatedArrayII {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[]{7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        for(int i : arr){
            list.add(i);
        }
        System.out.println(searchInARotatedSortedArrayII(list, 5));
    }
    public static boolean searchInARotatedSortedArrayII(ArrayList<Integer> nums, int k) {
        int start = 0;
        int end = nums.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums.get(mid) == k) return true;
            if(nums.get(start).equals(nums.get(mid)) && nums.get(mid).equals(nums.get(end))){
                end = end-1;
                start = start+1;
            }

            else if (nums.get(start) <= nums.get(mid)) {
                if (k >= nums.get(start) && k <= nums.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (k <= nums.get(end) && k >= nums.get(mid)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
