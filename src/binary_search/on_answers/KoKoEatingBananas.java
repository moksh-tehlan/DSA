package binary_search.on_answers;

public class KoKoEatingBananas {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 15, 6, 3};
        System.out.println(minimumRateToEatBananas(arr,8));
    }

    private static int minimumRateToEatBananas(int[] arr, int h) {
        int start = 1;
        int end = 1;
        for (int i : arr) {
            end = Math.max(end, i);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int currHour = hourTakenForBananas(mid, arr);
            if (currHour <= h) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int hourTakenForBananas(int b, int[] arr) {
        int hours = 0;
        for (int i : arr) {
            hours += (int) Math.ceil((double) i / b);
        }
        return hours;
    }
}
