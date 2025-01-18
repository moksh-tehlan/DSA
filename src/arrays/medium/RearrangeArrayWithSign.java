package arrays.medium;

import java.util.ArrayList;

public class RearrangeArrayWithSign {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5, -1, -3, -4};
        rearrangeArray(arr);
        for(int i : arr){
            System.out.print(i +" ");
        }
    }

    static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        int i = 0;
        int k = 0;
        while(i < n/2){
            nums[k++] = pos.get(i);
            nums[k++] = neg.get(i);
            i++;
        }
        return nums;
    }
}
