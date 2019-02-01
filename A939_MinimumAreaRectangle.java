import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A939_MinimumAreaRectangle {
    public static void main(String[] args) {
        A939_MinimumAreaRectangle solution = new A939_MinimumAreaRectangle();
        int[][] input = {{1,1}, {1,3}, {3,1}, {3,3}, {4,1}, {4,3}};
        int output = solution.minAreaRect(input);
        System.out.println(output);
    }

    /** use a little bit thinking of union find, we acn build x-axis to all corresponding y-axis mapping
     * and then check every two points: if two points can form a diagonal and there exists the other two
     * points that can form another diagonal of current rectangle, we will calculate the area and compare with min */
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // union all y-axis has same x-axis together
        for (int[] point : points) {
            map.putIfAbsent(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }

        int minArea = Integer.MAX_VALUE;
        for (int[] point1 : points) {
            for (int[] point2 : points) {
                int x1 = point1[0], y1 = point1[1];
                int x2 = point2[0], y2 = point2[1];

                // if x1 and x2 are in same line or y1 and y2 are in same line, these two points cannot form a diagonal line
                if (x1 == x2 || y1 == y2) {
                    continue;
                }

                // if x1 has an y value that same as y2 and x2 has an y value that same as y1
                if (map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
                    minArea = Math.min(minArea, Math.abs(x2 - x1) * Math.abs(y2 - y1));
                }
            }
        }
        // WARNING: DO NOT FORGET to check if minArea has already been updated
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
