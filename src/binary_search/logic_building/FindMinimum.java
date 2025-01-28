package binary_search.logic_building;

import java.util.ArrayList;

public class FindMinimum {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(9);
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(findMin(arr));
    }

    // 4, 5, 6, 7, 0, 1, 2, 3
    private static int findMin(ArrayList<Integer> arr) {
        int start = 0;
        int end = arr.size()-1;
        int min = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end-start) /2;

            if(arr.get(start) <= arr.get(mid)){
                min = Math.min(min,arr.get(start));
                start = mid+1;
            }else{
                min = Math.min(min,arr.get(mid));
                end = mid-1;
            }
        }
        return min;
    }
}
