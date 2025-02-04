package binary_search.on_answers;

public class FindNthRoot {
    public static void main(String[] args) {
        System.out.println(NthRoot(7,1));
    }

    private static int NthRoot(int N, int M) {
        int start = 1;
        int end = M;
        while(start <= end){
            int mid = start+(end-start)/2;
            int power = power(mid,N,M);
            if(power == M)return mid;
            else if(power > M)end = mid-1;
            else start = mid+1;
        }
        return -1;
    }

    private static int power(int x, int n, int m){
        return (int)Math.pow(x,n);
    }
}
