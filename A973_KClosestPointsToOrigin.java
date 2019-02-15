import java.util.PriorityQueue;

public class A973_KClosestPointsToOrigin {
    public static void main(String[] args) {
        A973_KClosestPointsToOrigin solution = new A973_KClosestPointsToOrigin();
        int[][] input = {{3,3}, {5,-1}, {-2,4}};
        int[][] output = solution.kClosest(input, 2);
        for (int[] point : output) {
            System.out.println(point[0] + " " + point[1]);
        }
    }

    /** use priority queue to store all points, sorted from low distance to high distance
     * and then pop top K items from priority queue into result array */
    public int[][] kClosest(int[][] points, int K) {
        if (points.length == 0 || K < 0) {
            return new int[0][0];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]));
        for (int[] point : points) {
            pq.offer(point);
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
