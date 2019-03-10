import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A957_PrisonCellsAfterNDays {
    public static void main(String[] args) {

    }

    /** Since N size can be very large, we cannot use brute force to go through every states. We need to find a pattern
     * to get how many days in this pattern cycle. So we can use N mod (# of cycle days) to get remainder. Finally we
     * can iterate the value of remainder days to get the result state */
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        while (N > 0) {
            int[] tempCells = new int[8];
            // use map to store current state with corresponding day value
            map.put(Arrays.toString(cells), N);

            for (int i = 1; i < 7; i++) {
                if (cells[i - 1] == cells[i + 1]) {
                    tempCells[i] = 1;
                }
                else {
                    tempCells[i] = 0;
                }
            }
            cells = tempCells;
            N--;

            // if we have seen this string before, it means we reach the end of loop cycle. Then we should only run
            // number of remainder times to get the result state
            if (map.containsKey(Arrays.toString(tempCells))) {
                int cycle = map.get(Arrays.toString(tempCells)) - N;
                N %= cycle;
            }
        }
        return cells;
    }
}
