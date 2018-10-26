import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A120_Triangle {
    public static void main(String[] args) {
        A120_Triangle solution = new A120_Triangle();
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(Arrays.asList(2));
        inputs.add(Arrays.asList(3, 4));
        inputs.add(Arrays.asList(6, 5, 7));
        inputs.add(Arrays.asList(4, 1, 8, 3));
        int output = solution.minimumTotal(inputs);
        System.out.println(output);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }

        int n = triangle.size();
        int m = triangle.get(n - 1).size();

        //dp(i, j) represents minimum path sum from the element in ith row and jth column to bottom
        int[][] dp = new int[n][m];

        //base case: assign each value from the entire bottom line to dp array
        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        //recurrence relation: start at second line from the bottom, to the top line
        //dynamically calculate minimum path from current level to bottom level by choosing smaller value
        //between dp[i+1][j] and dp[i+1][j+1]
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        //return: the top element will be the final minimum path sum
        return dp[0][0];
    }
}
