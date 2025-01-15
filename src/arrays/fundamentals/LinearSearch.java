package arrays.fundamentals;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,2,1,3,5,6};
        System.out.println(linearSearch(arr,5));
    }

    static int linearSearch(int nums[], int target) {
        for(int i = 0; i < nums.length; i++){
            if(target == nums[i]){
                return i;
            }
        }
        return -1;
    }
}
