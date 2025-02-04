package binary_search.logic_building;

public class SingleNonDuplicate {
    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(singleNonDuplicate(arr));
    }

    private static int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid % 2 != 0) {
                if(nums[mid] == nums[mid-1]){
                    start = mid + 1;
                }else{
                    end = mid-2;
                }
            } else {
                if(nums[mid] == nums[mid+1]){
                    start = mid+2;
                }else{
                    end = mid-1;
                }
            }
        }
        return nums[start];
    }
}
