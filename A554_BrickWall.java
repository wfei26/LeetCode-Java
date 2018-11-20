import java.util.*;

public class A554_BrickWall {
    public static void main(String[] args) {
        A554_BrickWall solution = new A554_BrickWall();
        int[][] lists = {{1,2,2,1},
                         {3,1,2},
                         {1,3,2},
                         {2,4},
                         {3,1,2},
                         {1,3,1,1}};
        List<List<Integer>> input = new ArrayList<>();
        for (int[] list : lists) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : list) {
                tempList.add(num);
            }
            input.add(tempList);
        }
        int output = solution.leastBricks(input);
        System.out.println(output);
    }

    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }

        // maxBorder represents the maximum number of overlapping borders in a vertical line
        int maxBorder = 0;

        // map stores length to frequency mapping, to count how many number of borders in same length
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int length = 0;
            // DO NOT INCLUDE last vertical line!!!, must use i < n - 1, NOT i < n
            for (int i = 0; i < list.size() - 1; i++) {
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                maxBorder = Math.max(maxBorder, map.get(length));
            }
        }
        return wall.size() - maxBorder;
    }
}
