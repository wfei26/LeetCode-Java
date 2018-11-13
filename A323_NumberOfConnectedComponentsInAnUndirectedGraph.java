public class A323_NumberOfConnectedComponentsInAnUndirectedGraph {
    public static void main(String[] args) {
        A323_NumberOfConnectedComponentsInAnUndirectedGraph solution = new A323_NumberOfConnectedComponentsInAnUndirectedGraph();
        int[][] inputs = {};
        int output = solution.countComponents(1, inputs);
        System.out.println(output);
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        //union find template with count
        private int count;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
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

        public void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) {
                return;
            }

            if (rank[parentA] == rank[parentB]) {
                parent[parentA] = parentB;
                rank[parentB]++;
            }
            else if (rank[parentA] > parentB) {
                parent[parentB] = parentA;
            }
            else {
                parent[parentA] = parentB;
            }
            //every time union successfully, count--
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public int countComponents(int n, int[][] edges) {
        //corner case: n, {}
        if (edges.length == 0) {
            return n;
        }

        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.getCount();
    }
}
