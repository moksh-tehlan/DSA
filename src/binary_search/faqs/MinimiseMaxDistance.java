package binary_search.faqs;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimiseMaxDistance {
    public static void main(String[] args) {
        int[] arr = new int[]{35,44,54,61,67,72,77,99};
        System.out.println(minimiseMaxDistance(arr, 88));
    }

    private static double minimiseMaxDistance(int[] arr, int k) {
//        return bruteForce(arr, k);
        return optimisedSolution(arr, k);
    }

    private static double bruteForce(int[] arr, int k) {
        int[] howMany = new int[arr.length - 1];

        for (int i = 0; i < k; i++) {
            double maxDifference = -1;
            int maxDiffIdx = -1;

            for (int j = 0; j < arr.length - 1; j++) {
                double diff = arr[j + 1] - arr[j];
                double secLength = diff / (double) (howMany[j] + 1);

                if (maxDifference < secLength) {
                    maxDifference = secLength;
                    maxDiffIdx = j;
                }
            }

            howMany[maxDiffIdx]++;
        }

        double maxAns = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            double ans = (arr[i + 1] - arr[i]) / (double) (howMany[i] + 1);
            maxAns = Math.max(maxAns, ans);
        }
        return maxAns;
    }

    public static double optimisedSolution(int[] arr, int k) {
        Queue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length - 1; i++) {
            double secLength = arr[i + 1] - arr[i];
            pq.offer(new Pair(secLength, i));
        }

        int howMany[] = new int[arr.length-1];
        for(int i = 0; i < k ; i++){
            Pair maxElement = pq.remove();
            int maxIndex = maxElement.index;
            double originalSecLength = arr[maxIndex+1]-arr[maxIndex];


            howMany[maxIndex]++;

            double newSecLength = originalSecLength /(double) (howMany[maxIndex]+1);
            pq.offer(new Pair(newSecLength,maxIndex));
        }
        return pq.element().secLength;
    }

}

class Pair implements Comparable {
    Pair(double secLength, int index) {
        this.secLength = secLength;
        this.index = index;
    }

    double secLength;
    int index;

    @Override
    public int compareTo(Object o) {
        Pair that = (Pair) o;

        return this.compare(this, that);
    }

    int compare(Pair pair1, Pair pair2) {
        if (pair1.secLength == pair2.secLength) {
            return pair2.index - pair1.index;
        }
        return Double.compare(pair2.secLength, pair1.secLength);
    }
}


