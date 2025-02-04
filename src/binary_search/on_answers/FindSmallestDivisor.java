package binary_search.on_answers;

import java.util.Arrays;

public class FindSmallestDivisor {
    public static void main(String[] args) {
        int[] arr = new int[]{62073,67423,4830,43571,14638,19161,16486,61899,58879,45306,58774,37783,33306,72140,53602,74710,73220,361,22646,15815,52955,25015,68989,91813,84090,55308,24244,6741,15801,56648,84119,94909,64735,42813,74862,66920,9219,63017,85541,74004,68647,26454,52985,225,95795,1570,15168,40332,2707,25798,56270,34440,39646,34290,91602,20307,57849,32504,89996,84452,79621,19741,23370,9205,99947,79766,87642,99322,3585,84321,24316,16947,35980,86225,46274,96197,17065,31591,71118,42241,83892,59844,96448,48673,72848,94699,34528,43624,25776,7924,87816,8150,77919,83628,72652,50360,14672,15529,99682,34769};
        System.out.println(smallestDivisor(arr,1434));
    }

    private static int smallestDivisor(int[] nums, int limit) {
        int end = 0;
        for(int i : nums){
            end = Math.max(i,end);
        }
        int start = 1;

        while(start <= end){
            int mid = start + (end-start)/2;
            int calculateSumWithCurrentDivisor = calculateSum(nums,mid);
            if(calculateSumWithCurrentDivisor <= limit){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    static int calculateSum(int[] arr, int divisor){
        int sum = 0;
        for(int i : arr){
            sum += (int) Math.ceil((double) i/divisor);
        }
        return sum;
    }
}
