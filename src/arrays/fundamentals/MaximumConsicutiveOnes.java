package arrays.fundamentals;

public class MaximumConsicutiveOnes {
    public static void main(String[] args) {
        int[] arr= new int[]{1, 1, 0, 0, 1, 1, 1, 0};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
    static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        for(int i : nums){
            if(i == 1){
                curr++;
                max = Math.max(curr,max);
            }else{
                curr = 0;
            }
        }
        return max;
    }
}
