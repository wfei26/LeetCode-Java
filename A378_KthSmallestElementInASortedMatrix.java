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

    /** High level logic is completely same as merge k sorted list. We can maintain a priority queue with size
     * less than or equal to n (total number of rows). We poll smallest element from pq at the beginning of
     * every iteration, then we can add the following element in the same line with the polled element until
     * find k-th smallest element */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (k > n * m) {
            return -1;
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < n; i++) {
            pq.offer(new Tuple(i, 0, matrix[i][0]));
        }

        while (k > 1) {
            Tuple curTuple = pq.poll();
            // if current line still has element, add into queue
            if (curTuple.y < m - 1) {
                pq.offer(new Tuple(curTuple.x, curTuple.y + 1, matrix[curTuple.x][curTuple.y + 1]));
            }
            k--;
        }
        return pq.poll().val;
    }

    class Tuple {
        int x;
        int y;
        int val;

        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}

