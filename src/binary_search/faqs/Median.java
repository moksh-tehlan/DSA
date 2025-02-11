package binary_search.faqs;

public class Median {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 4, 6};
        int[] arr2 = new int[]{1, 3, 5};
        System.out.println(median(arr1, arr2));
    }

    private static double median(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        if(n1 > n2)return median(arr2,arr1);

        int n = n1+n2;
        int start = 0, end = n1;
        int left = (n+1)/2;

        while(start <= end){
            int mid1 = start+(end-start)/2;
            int mid2 = left-mid1;

           int l1 = Integer.MIN_VALUE,l2 = Integer.MIN_VALUE;
           int r1 = Integer.MAX_VALUE,r2 = Integer.MAX_VALUE;

           if(mid1 < n1)r1 = arr1[mid1];
           if(mid2 < n2)r2 = arr2[mid2];
           if(mid1-1 >= 0)l1 = arr1[mid1-1];
           if(mid2-1 >= 0)l2 = arr2[mid2-1];

           if(l1 <= r2 && l2 <= r1){
               if(n % 2 == 0){
                   return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
               }else{
                   return Math.max(l1,l2);
               }
           }else if(l1 > r2) end = mid1-1;
           else start = mid1+1;
        }
        return 0;
    }
}
