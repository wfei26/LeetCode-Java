public class A547_FriendCircles {
    public static void main(String[] args) {
        A547_FriendCircles solution = new A547_FriendCircles();
        int[][] friends = {{1,1,0},
                           {1,1,1},
                           {0,1,1}};
        int output = solution.findCircleNum(friends);
        System.out.println(output);
    }

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int n = M.length;
        UnionFind unionfind = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) unionfind.union(i, j);
            }
        }
        return unionfind.count();
    }
}

class UnionFind {
    private int count = 0;
    private int[] parent, rank;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        //rank means number of children level of current node
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int a, int b) {
        int rootOfA = find(a);
        int rootOfB = find(b);

        //if they are share the same root, they are in same group
        //do not update count, just return
        if (rootOfA == rootOfB) {
            return;
        }
        //if they are not in the same group, adjust rank and update count
        else if (rank[rootOfB] > rank[rootOfA]) {
            parent[rootOfA] = parent[rootOfB];
        }
        else {
            parent[rootOfB] = rootOfA;
            if (rank[rootOfA] == rank[rootOfB]) {
                rank[rootOfA]++;
            }
        }
        count--;
    }

    public int find(int a) {
        while (a != parent[a]) {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return a;
    }

    public int count() {
        return count;
    }
}
