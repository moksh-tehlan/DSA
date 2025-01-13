package sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,2,3,6,5,1,4,7};
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }

    // insertion sort
    // we assume that the left part of the array is sorted
    // and from right side we take an element and we see where we can fix it on the left side
    static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
