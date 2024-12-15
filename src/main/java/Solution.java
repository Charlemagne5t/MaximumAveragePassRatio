import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double res = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) ->   - ((double)(a[0] + 1) / (a[1] + 1) - (double)a[0] / a[1])));
        int countPerfect = 0;
        for(int[] a : classes) {
            if(a[1] != a[0]){
                pq.offer(a);
            }else countPerfect++;

        } 
        
        while(!pq.isEmpty() && extraStudents != 0) {
            int[] top  = pq.poll();
            top[0]++;
            top[1]++;
            pq.offer(top);
            extraStudents--;
        }
        double sum = (double)countPerfect;
        while(!pq.isEmpty()) {
            int[] std = pq.poll();
            sum += (double)(std[0]) / std[1]; 
        }

        return sum / classes.length;
    }
}