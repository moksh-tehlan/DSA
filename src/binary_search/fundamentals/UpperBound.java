package binary_search.fundamentals;

public class UpperBound {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,2,3};
        int target = 2;
        System.out.println(upperBound(arr,target));
    }

    static int upperBound(int[] nums, int x) {
        int start =  0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end- start) /2;
            if(x >= nums[mid])start = mid+1;
            else end = mid-1;
        }
        return end;
    }
}
