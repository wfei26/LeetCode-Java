import java.util.HashSet;
import java.util.Set;

public class A947_MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        A947_MostStonesRemovedWithSameRowOrColumn solution = new A947_MostStonesRemovedWithSameRowOrColumn();
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int output = solution.removeStones(stones);
        System.out.println(output);
    }

    /*
    * We can convert this problem to counting number of islands. We can find how many points have sharing x or y
    * coordinates, and then union them together. We will get final count of independent island. Then we can use
    * total number of stones - count of island to get the result.
    *
    * Since we want to union x and y coordinate together to determine whether new input coordinates have
    * sharing x or y coordinates with previous coordinates, we have to use a strategy to change all y-coordinates
    * to another range, in order to remove conflicts with x-coordinates.
    * The way we do it is that add every y-coordinate by 10000, so that the range of x-coordinates are [0, 10000],
    * and the range of y-coordinates are [10001, 20000]
    * */
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        UnionFind unionFind = new UnionFind(20000);
        for (int i = 0; i < stones.length; i++) {
            unionFind.union(stones[i][0], stones[i][1] + 10000);
        }
        return stones.length - unionFind.count;
    }

    class UnionFind {
        private int count;
        private int[] parent, rank;
        Set<Integer> seen = new HashSet<>();

        public UnionFind (int size) {
            parent = new int[size];
            rank = new int[size];

            // since we do not know how many duplicate x or y coordinate do exist in the input array
            // we could not initialize the original size. We should dynamically add total size when
            // we see a brand new x or y coordinate that never seen before
            count = 0;

            // DO NOT FORGET to initialize every parent and its rank value
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // recursively find the root of disjoint set that input value belong to
        public int find(int x) {
            // if the input x or y coordinate is new, add size by 1
            if (seen.add(x)) {
                count++;
            }

            // recursively find the root of input value
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            // if two number have same root, we do not need to union them again, and keep the size unchanged
            if (rootA == rootB) {
                return;
            }

            // if root of two nodes have same rank, merge any one of them to another one,
            // and increase rank of another root by 1
            if (rank[rootA] == rank[rootB]) {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
            // if root of two nodes have different rank, merge the one with lower rank to the one with higher rank
            else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            }
            else {
                parent[rootA] = rootB;
            }
            // after merging, size number --
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
