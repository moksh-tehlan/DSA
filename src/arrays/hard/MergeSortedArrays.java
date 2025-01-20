package arrays.hard;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{-5, -2, 4, 5,0,0,0};
        int[] nums2 = new int[]{-3, 1, 8};
        merge(nums1,4,nums2,3);
        for(int i : nums1){
            System.out.print(i+" ");
        }
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = 0;
        while(i >= 0 && j < n){
            if(nums1[i] > nums2[j]){
                swap(nums1,i,nums2,j);
                i--;
                j++;
            }else{
                break;
            }

        }
        Arrays.sort(nums1,0,m);
        Arrays.sort(nums2);

        System.arraycopy(nums2,0,nums1,m,n);
    }

    static void swap(int[] nums1, int i, int[] nums2, int j){
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
    }
}
