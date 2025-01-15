package arrays.logicbuilding;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 4, 0, 5, 2};
        moveZeros(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    static void moveZeros(int[] arr){
        int zeroIndex = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0 && zeroIndex == -1){
                zeroIndex = i;
            }else if(arr[i] != 0 && zeroIndex != -1){
                swap(arr,zeroIndex,i);
                zeroIndex++;
            }
        }
    }

    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
