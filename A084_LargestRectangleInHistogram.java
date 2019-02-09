import java.util.Stack;

public class A084_LargestRectangleInHistogram {
    public static void main(String[] args) {
        A084_LargestRectangleInHistogram solution = new A084_LargestRectangleInHistogram();
        int[] heights = {2,1,5,6,2,3};
        int myResult = solution.largestRectangleArea(heights);
        System.out.println(myResult);
    }

    /** main a monotonic increasing stack, and iteratively update max area
     *  */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
