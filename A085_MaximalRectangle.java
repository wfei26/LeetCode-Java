import java.util.Stack;

public class A085_MaximalRectangle {
    public static void main(String[] args) {
        A085_MaximalRectangle solution = new A085_MaximalRectangle();
        char[][] myInputs = {{'1','0','1','0','0'},
                             {'1','0','1','1','1'},
                             {'1','1','1','1','1'},
                             {'1','0','0','1','0'}};
        int myResult = solution.maximalRectangle(myInputs);
        System.out.println(myResult);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int result = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                }
                else {
                    height[j] = 0;
                }
            }

            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int maxArea = 0;
            for (int k = 0; k < height.length; k++) {
                while (stack.peek() != -1 && height[stack.peek()] >= height[k]) {
                    maxArea = Math.max(maxArea, height[stack.pop()] * (k - stack.peek() - 1));
                }
                stack.push(k);
            }
            while (stack.peek() != -1) {
                maxArea = Math.max(maxArea, height[stack.pop()] * (height.length - stack.peek() - 1));
            }
            result = Math.max(result, maxArea);
        }
        return result;
    }
}
