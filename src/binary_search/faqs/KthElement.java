package binary_search.faqs;

public class KthElement {
    public static void main(String[] args) {
        int[] arr = new int[]{100};
        int[] arr2 = new int[]{72, 86, 113, 119, 265, 445, 8920,10000,10001,10002,10003};
        System.out.println(kthElement(arr, arr2, 7));
    }

    private static int kthElement(int[] a, int[] b, int k) {

        if (a.length > b.length) return kthElement(b, a, k);

        int aLength = a.length;
        int bLength = b.length;

        int start = Math.max(0,k-bLength);
        int end = Math.min(k,aLength);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int elementFromRight = k - mid;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid < aLength)r1  = a[mid];
            if(elementFromRight < bLength)r2 = b[elementFromRight];
            if(mid-1 >= 0) l1 = a[mid-1];
            if(elementFromRight-1 >= 0)l2 = b[elementFromRight-1];

            if(l1 < r2 && l2 < r1)return Math.max(l1,l2);
            else if(l1 > r2)end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}
