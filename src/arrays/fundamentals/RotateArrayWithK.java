package arrays.fundamentals;

public class RotateArrayWithK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        rotateArrayByK(arr,3);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // right rotate array
    static void rotateArrayByK(int[] arr,int k){
        int n = arr.length;
        k = k % n;
        reverseArray(arr,0,n-k-1);
        reverseArray(arr,n-k,n-1);
        reverseArray(arr,0,n-1);
    }

    // left rotate array
    static void leftRotateArrayByK(int[] arr,int k){
        int n = arr.length;
        k = k % n;
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,n-1);
        reverseArray(arr,0,n-1);
    }
    
    static void reverseArray(int[] arr, int l , int r){
        while(l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
