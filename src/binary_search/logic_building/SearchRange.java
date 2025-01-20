package binary_search.logic_building;

public class SearchRange {
    public static void main(String[] args) {
        int[] ques = new int[]{5, 7, 7, 8, 8, 10};
        int[] arr = searchRange(ques,5);
        System.out.println("lower: "+arr[0]+" upper: "+arr[1]);
    }

    static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int lower;
        int upper;

        while(start <= end){
            int mid = start+(end-start)/2;

            if(target <= nums[mid])end = mid-1;
            else start = mid+1;
        }

        lower = start;

        start = 0;
        end = nums.length-1;

        while(start <= end){
            int mid = start+(end-start)/2;

            if(target >= nums[mid])start = mid+1;
            else end = mid-1;
        }

        upper = end;

        if(upper < lower){
            return new int[]{-1,-1};
        }
        return new int[]{lower,upper};
    }
}
