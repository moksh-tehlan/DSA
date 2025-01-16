package arrays.logicbuilding;

import java.util.Arrays;

public class UnionArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 4, 6, 7, 9, 9};
        int[] arr2 = new int[]{1, 5, 7, 8, 8};
        int[] ans = unionArray(arr1, arr2);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    static int[] unionArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (k > 0 && arr[k - 1] == nums1[i]) {
                i++;
            } else if (k > 0 && arr[k - 1] == nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
                k++;
            } else {
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < n) {
            if (arr[k - 1] != nums1[i]) {
                arr[k] = nums1[i];
                k++;
            }
            i++;
        }
        while (j < m) {
            if (arr[k - 1] != nums2[j]) {
                arr[k] = nums2[j];
                k++;
            }
            j++;
        }
        return Arrays.copyOfRange(arr, 0, k);
    }
}
