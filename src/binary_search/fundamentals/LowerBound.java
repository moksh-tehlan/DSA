package binary_search.fundamentals;

public class LowerBound {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,2,3};
        int target = 4;
        System.out.println(lowerBound(arr,target));
    }

    static int lowerBound(int[] nums, int x) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(x <= nums[mid])end = mid-1;
            else start = mid+1;
        }
        return start;
    }
}
