package arrays.fundamentals;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr=  new int[]{8,8,7,6,5};
        System.out.println(secondLargestElement(arr));
    }

    static int secondLargestElement(int[] arr){
        int largest = Integer.MIN_VALUE;
        int sLargest = largest;
        for(int i : arr){
            if(i > largest){
                sLargest = largest;
                largest = i;
            }
            if(i < largest && i > sLargest){
                sLargest = i;
            }
        }
        return sLargest == Integer.MIN_VALUE ? -1 : sLargest;
    }
}
