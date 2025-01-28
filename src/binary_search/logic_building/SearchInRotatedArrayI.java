package binary_search.logic_building;

public class SearchInRotatedArrayI {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, -2, -1, 0, 1, 2, 3};
        System.out.println(search(arr, 5));
    }

    private static int search(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == k) return mid;
            else if (nums[start] <= nums[mid]) {
                if (k >= nums[start] && k <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (k <= nums[end] && k >= nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
