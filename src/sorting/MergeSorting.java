package sorting;

public class MergeSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(arr,0,arr.length-1);
        printArray(arr);
        
    }

    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void mergeSort(int[] arr,int s,int e){
        if (s < e){
            int m = (e + s) / 2;
            mergeSort(arr, s, m);
            mergeSort(arr, m+1, e);
            merge(arr, s, m, e);
        }
    }

    static void merge(int[] arr,int s,int m ,int e){
        int[] sortedArray = new int[e-s+1];

        int i = s;
        int j = m+1;
        int k = 0;

        while(i <= m && j <= e){
            if(arr[i] < arr[j]){
                sortedArray[k] = arr[i];
                i++;
            }else{
                sortedArray[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= m){
            sortedArray[k] = arr[i];
            i++;
            k++;
        }

        while(j <= e){
            sortedArray[k] = arr[j];
            j++;
            k++;
        }

        for(int x = s; x <= e; x++){
            arr[x] = sortedArray[x-s];
        }
    }
}
