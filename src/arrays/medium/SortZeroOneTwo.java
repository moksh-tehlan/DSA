package arrays.medium;

public class SortZeroOneTwo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        sortZeroOneTwo(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    static void sortZeroOneTwo(int[] arr) {
        int z = 0;
        int o = 0;
        int t = 0;
        for(int i : arr){
            if( i == 0)z++;
            else if(i == 1)o++;
            else t++;
        }

        int k = 0;
        while(z-- > 0){
            arr[k++] = 0;
        }
        while(o-- > 0){
            arr[k++] = 1;
        }
        while(t-- > 0){
            arr[k++] = 2;
        }
    }
}
