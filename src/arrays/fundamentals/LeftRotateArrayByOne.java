package arrays.fundamentals;

public class LeftRotateArrayByOne {
    public static void main(String[] args) {
        int[] arr= new int[]{1,2,3,4,5};
        rotateArrayByOne(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    static void rotateArrayByOne(int[] nums) {
        int first=nums[0];
        for(int i = 0; i < nums.length-1; i++){
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = first;
    }
}
