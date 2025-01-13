package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int[] sortedArray = sortArray(arr);

        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
        
    }

    static int[] sortArray(int[] arr){
        int n = arr.length;
        for(int i = 0 ; i < n-1; i++){
            int smallest = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
        return arr;
    }
}
