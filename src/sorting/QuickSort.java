package sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,3,5,6,8,7,2};
        quickSort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    // pick a pivot
    // smaller on the left and greater on the right of pivot
    // perform this until one element is left
    static void quickSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int pivot = partition(arr,low,high);
        quickSort(arr,low,pivot-1);
        quickSort(arr,pivot+1,high);
    }

    static int partition(int[] arr,int low,int high){
        int pivot = arr[low];

        int  i = low;
        int j = high;
        while (i<j){
            while (i <= high && arr[i] <= pivot){
                i++;
            }

            while(j >= low && arr[j] > pivot){
                j--;
            }

            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;
        return j;
    }
}
