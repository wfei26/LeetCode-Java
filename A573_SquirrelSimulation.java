public class A573_SquirrelSimulation {
    public static void main(String[] args) {
        A573_SquirrelSimulation solution = new A573_SquirrelSimulation();
        int[] tree = {2,2};
        int[] squirrel = {4,4};
        int[][] nuts = {{3,0}, {2,5}};
        int output = solution.minDistance(5, 7, tree, squirrel, nuts);
        System.out.println(output);
    }

    /** the total minimum distance should be sum of manhattan distance between n - 1 nuts to tree plus manhattan
     * distance of squirrel to first nut and first nut to tree. So we can calculate total distance from all nuts
     * to tree, and then find max difference between distance of each nut to tree and each nut to squirrel, since
     * we want to find min distance of first nut */
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int totalDistance = 0;
        int maxDifference = Integer.MIN_VALUE;
        for (int i = 0; i < nuts.length; i++) {
            int treeToNutsDist = Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1]);
            // accumulate distance of (tree to nut + nut to tree)
            totalDistance += treeToNutsDist * 2;

            int squirrelToNusDist = Math.abs(squirrel[0] - nuts[i][0]) + Math.abs(squirrel[1] - nuts[i][1]);
            // max diff between treeToNuts and squirrelToNuts represents min distance between squirrel to nut
            maxDifference = Math.max(maxDifference, treeToNutsDist - squirrelToNusDist);
        }
        // 所有坚果到树的距离 * 2 - （第一个坚果到树的距离比第一个坚果到松鼠多出的距离）
        return totalDistance - maxDifference;
    }
}

