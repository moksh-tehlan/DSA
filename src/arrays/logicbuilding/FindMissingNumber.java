package arrays.logicbuilding;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 2, 3, 1, 4};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] arr){
        int n = arr.length;
        int naturalSum = (n * (n+1))/2;
        int fakeSum = 0;
        for(int i : arr){
            fakeSum += i;
        }
        return naturalSum-fakeSum;
    }
}
