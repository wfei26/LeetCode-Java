public class A256_PaintHouse {
    public static void main(String[] args) {
        A256_PaintHouse solution = new A256_PaintHouse();
    }

    /** use original input array as dp array. accumulate previous two different cost with each cost of current color
     * until reach the end of array. Then we have all leaf values, then get min value */
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        int res = Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]);
        res = Math.min(res, costs[costs.length - 1][2]);
        return res;
    }
}
