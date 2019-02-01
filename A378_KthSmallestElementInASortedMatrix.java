import java.util.PriorityQueue;

public class A378_KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        A378_KthSmallestElementInASortedMatrix solution = new A378_KthSmallestElementInASortedMatrix();
        int[][] inputs = {{1,  5,   9},
                          {10, 11, 13},
                          {12, 13, 15}};
        int output = solution.kthSmallest(inputs, 8);
        System.out.println(output);
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo (Tuple that) {
            return this.val - that.val;
        }
    }
}

