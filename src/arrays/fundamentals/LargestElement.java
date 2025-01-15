package arrays.fundamentals;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(largestElement(arr));
    }
    static int largestElement(int[] nums) {
        int largest = Integer.MIN_VALUE;

        for(int i : nums){
            largest = Math.max(largest,i);
        }
        return largest;
    }
}
