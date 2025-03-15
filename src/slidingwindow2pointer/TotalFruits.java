package slidingwindow2pointer;

import java.util.HashMap;
import java.util.Map;

public class TotalFruits {
    public static void main(String[] args) {
        int[] ques = new int[]{1, 2, 3, 3, 2, 2, 2, 1, 1, 1, 1};
        System.out.println(totalFruits(ques));
    }

    private static int totalFruits(int[] fruits) {
        int r = 0, l = 0;
        int n = fruits.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            if(map.size() > 2){
                map.put(fruits[l],map.getOrDefault(fruits[l],0)-1);
                if(map.get(fruits[l]) == 0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size() <= 2){
                max = Math.max(max,r-l+1);
            }
            r++;
        }
        return max;
    }
}
