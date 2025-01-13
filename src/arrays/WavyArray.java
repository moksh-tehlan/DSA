package arrays;

import java.util.Arrays;

public class WavyArray {
    public static void main(String[] args) {
        int[] arr = {1,9,5,2,0,7,4,8,3,6};
        int[] arr2 = {1,9,5,2,0,7,4,8,3,6};
        System.out.println("Original Array: " + Arrays.toString(arr));
        printWavyArrayLexicographically(arr);
        printWavyArrayNormally(arr2);
    }
    
    static void printWavyArrayLexicographically(int[] arr){
        Arrays.sort(arr);
        for(int i = 1; i < arr.length-1; i+=2){
            replaceElement(arr,i-1,i);
        }
        System.out.println("Wavy Array: " + Arrays.toString(arr));
    }

    static void printWavyArrayNormally(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i+=2){
            if(arr[i] > arr[i-1]){
                replaceElement(arr,i,i-1);
            }
            if(i < n-1 && arr[i] > arr[i+1]){
                replaceElement(arr,i,i+1);
            }
        }
        System.out.println("Wavy Array: " + Arrays.toString(arr));
    }
    
    static void replaceElement(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
