package binary_search.on_answers;

public class FindSqrt {
    public static void main(String[] args) {
        System.out.println(floorSqrt(450));
    }

    private static long floorSqrt(long n) {
        long start = 1;
        long end = n;

        while(start <= end){
            long mid = start + (end- start)/2;
            long sqr = mid*mid;
            if(sqr == n)return mid;
            else if(sqr > n)end= mid-1;
            else start = mid+1;
        }
        return end;
    }
}
