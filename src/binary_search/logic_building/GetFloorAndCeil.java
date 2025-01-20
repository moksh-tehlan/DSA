package binary_search.logic_building;

public class GetFloorAndCeil {
    public static void main(String[] args) {
        int[] arr = getFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10},5);
        System.out.println("floor: "+arr[0]+" ceil: "+arr[1]);
    }

    static int[] getFloorAndCeil(int[] nums, int target) {
        if (target < nums[0]) return new int[]{-1, nums[0]};
        if (target > nums[nums.length - 1]) return new int[]{nums[nums.length - 1], -1};
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start+ (end-start)/2;

            if (nums[mid] == target) return new int[]{nums[mid], nums[mid]};
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }

        return new int[]{nums[end],nums[start]};
    }
}
