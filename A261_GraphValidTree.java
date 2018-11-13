public class A261_GraphValidTree {
    public static void main(String[] args) {
        A261_GraphValidTree solution = new A261_GraphValidTree();
        int[][] inputs = {{0,1}, {2,3}};
        boolean output = solution.validTree(4, inputs);
        System.out.println(output);
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
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

        public boolean union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) {
                return false;
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
            count--;
            return true;
        }

        public int getCount() {
            return count;
        }
    }

    //similar to 547 (friend circle)
    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) {
            return true;
        }

        UnionFind unionFind = new UnionFind(n);
        //once find an edge cannot union to current graph, it means this edge is redundant,
        //then this edge will form a circle if merge to current graph
        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                return false;
            }
        }
        //only if there exist one graph (disjoint set), return true
        if (unionFind.getCount() == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
