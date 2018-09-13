import javax.naming.spi.NamingManager;

public class A239_SlidingWindowMaximum {
    public static void main(String[] args) {
        A239_SlidingWindowMaximum solution = new A239_SlidingWindowMaximum();
        int[] myInputs = {1,3,-1,-3,5,3,6,7};
        int size = 3;
        int[] myResults = solution.maxSlidingWindow(myInputs, size);
        for (int i = 0; i < myResults.length; i++) {
            System.out.println(myResults[i]);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] results = new int[n - k + 1];

        int[] leftLocalMax = new int[n];
        int[] rightLocalMax = new int[n];
        leftLocalMax[0] = nums[0];
        rightLocalMax[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                leftLocalMax[i] = nums[i];
            }
            else {
                leftLocalMax[i] = Math.max(leftLocalMax[i - 1], nums[i]);
            }
            int j = n - i - 1;
            if (j % k == 0) {
                rightLocalMax[j] = nums[j];
            }
            else {
                rightLocalMax[j] = Math.max(rightLocalMax[j + 1], nums[j]);
            }
        }


        for (int i = 0; i <= n - k; i++) {
            results[i] = Math.max(leftLocalMax[i + k - 1], rightLocalMax[i]);
        }
        return results;
    }
}
