package arrays.hard;

public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 4, 1, 2, 7};
        System.out.println(reversePairs(arr));
    }

    static int reversePairs(int[] arr) {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }

    static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += countInversions(arr, low, mid, high);
            merge(arr, low, mid, high);
        }
        return count;
    }

    static int countInversions(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > (2 * arr[right])) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int size = high - low + 1;
        int[] newArr = new int[size];

        int k = 0;
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                newArr[k++] = arr[i++];
            } else {
                newArr[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            newArr[k++] = arr[i++];
        }

        while (j <= high) {
            newArr[k++] = arr[j++];
        }

        System.arraycopy(newArr, 0, arr, low, size);
    }
}
