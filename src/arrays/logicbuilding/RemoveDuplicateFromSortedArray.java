package arrays.logicbuilding;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 3, 3, 5, 6};
        int n = removeDuplicates(arr);
        System.out.println(n);
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    static int removeDuplicates(int[] arr){
        int lastElementIndex = 0;
        for(int i = 1;i < arr.length; i++){
            if(arr[i] != arr[lastElementIndex]){
                lastElementIndex++;
                arr[lastElementIndex] = arr[i];
            }
        }
        return lastElementIndex+1;
    }
}
