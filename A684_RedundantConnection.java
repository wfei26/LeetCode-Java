public class A684_RedundantConnection {
    public static void main(String[] args) {
        A684_RedundantConnection solution = new A684_RedundantConnection();
        int[][] inputs = {{1,2}, {1,3}, {2,3}};
        int[] output = solution.findRedundantConnection(inputs);
        System.out.println(output[0] + " " + output[1]);
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            //WARNING: we should use size + 1 at here, since this problem start from number 1, not 0
            parent = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 1; i < size + 1; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) {
                return false;
            }

            //CAUTION: DO NOT use input a or b below, must use parentA or parentB
            if (rank[parentA] == rank[parentB]) {
                parent[parentA] = parentB;
                rank[parentB]++;
            }
            else if (rank[parentA] > rank[parentB]) {
                parent[parentB] = parentA;
            }
            else {
                parent[parentA] = parentB;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        //traverse all edges, once find two number in an edge cannot union together,
        //it means they have already union before, this edge is redundant
        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }
}
