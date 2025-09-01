import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparing(
                        (int[] a) -> -((double)(a[0] + 1) / (a[1] + 1) - (double)(a[0]) / (a[1]))
                )
        );
        for(int[] c : classes){
            pq.offer(c);
        }
        double sum = 0.0;
        while(!pq.isEmpty() && extraStudents != 0) {
            int[] cur = pq.poll();
            if(cur[0] == cur[1]){
                sum += 1;
                continue;
            }
            cur[0]++;
            cur[1]++;
            extraStudents--;
            pq.offer(cur);
        }
        int count = classes.length;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            sum += (double) (cur[0]) / cur[1];
        }

        return sum / count;
    }
}