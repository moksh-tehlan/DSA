package binary_search.logic_building;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr  = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(arr,0));
    }

    static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start+ (end-start)/2;

            if(target <= nums[mid])end = mid-1;
            else start = mid+1;
        }
        return start;
    }
}
