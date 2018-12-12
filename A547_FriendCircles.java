public class A547_FriendCircles {
    public static void main(String[] args) {
        A547_FriendCircles solution = new A547_FriendCircles();
        int[][] friends = {{1,1,0},
                           {1,1,1},
                           {0,1,1}};
        int output = solution.findCircleNum(friends);
        System.out.println(output);
    }

    class UnionFind {
        private int count;
        private int[] parent, rank;

        public UnionFind (int size) {
            parent = new int[size];
            rank = new int[size];
            count = size;
            // DO NOT FORGET to initialize every parent and its rank value
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // recursively find the root of disjoint set that input value belong to
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

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
            // after merging, friend circle number --
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int n = M.length;
        UnionFind unionfind = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    // if two pos have relationship, union their friend circles into one friend circle
                    // will determine whether we need to union in union() function
                    unionfind.union(i, j);
                }
            }
        }
        return unionfind.getCount();
    }
}

