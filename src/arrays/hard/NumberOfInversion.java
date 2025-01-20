package arrays.hard;

public class NumberOfInversion {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 1, 3, 5};
        System.out.println(numberOfInversions(arr));
    }

    static long numberOfInversions(int[] nums) {
        int n = nums.length;
        return mergeSort(nums,0,n-1);
    }

    static long mergeSort(int[] arr, int l,int r){
        long count = 0;
        if(l < r){
            int mid = l+ ( r-l )/2;
            count += mergeSort(arr,l,mid);
            count += mergeSort(arr,mid+1,r);
            count += merge(arr,l,mid,r);
        }
        return count;
    }

    static long merge(int[] arr, int left,int mid,int right){
        int size = right-left+1;
        int[] newArray = new int[size];
        long count = 0;
        int k = 0;
        int i = left;
        int j = mid+1;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                newArray[k++] = arr[i++];
            }else{
                newArray[k++] = arr[j++];
                count += (mid-i+1);
            }
        }

        while(i <= mid){
            newArray[k++] = arr[i++];
        }

        while(j <= right){
            newArray[k++] = arr[j++];
        }

        System.arraycopy(newArray,0,arr,left,size);
        return count;
    }
}
