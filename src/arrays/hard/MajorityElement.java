package arrays.hard;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,2,2,2,2,1,1};
        System.out.println(majorityElement(arr));
    }

    static int majorityElement(int[] arr) {
        int me = arr[0];
        int mf = 0;
        for(int i : arr){
            if(me == i){
                mf++;
            }else{
                mf--;
            }
            if(mf <= 0){
                mf = 1;
                me = i;
            }
        }
        return me;
    }
}
