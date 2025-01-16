package arrays.logicbuilding;

import java.util.Arrays;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 2, 3, 5};
        int[] arr2 = new int[]{1, 2, 7};
        int[] ans = intersectionArray(arr1, arr2);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    static int[] intersectionArray(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int n = nums1.length;
        int m = nums2.length;

        int[] arr = new int[n+m];
        while(i < n && j < m){
            if(nums1[i] < nums2[j] || (k > 0 && arr[k-1] == nums1[i])){
                i++;
            }else if(nums2[j] < nums1[i]|| (k > 0 && arr[k-1] == nums2[j])){
                j++;
            }else{
                arr[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(arr,k);
    }
}
