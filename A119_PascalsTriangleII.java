import java.util.ArrayList;
import java.util.List;

public class A119_PascalsTriangleII {
    public static void main(String[] args) {
        A119_PascalsTriangleII solution = new A119_PascalsTriangleII();
        List<Integer> res = solution.getRow(5);
        for (int num : res) {
            System.out.println(num);
        }
    }

    /** only use 1-d array, append 1 at the first position at the beginning of every iteration, then update from second
     * index to the second from last. the new value is val of current index + val of (current index + 1) */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if (rowIndex < 0)
            return res;

        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(0, 1);
            for (int j = 1; j < res.size() - 1; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
        }
        return res;
    }
}
