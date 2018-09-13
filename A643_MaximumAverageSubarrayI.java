public class A643_MaximumAverageSubarrayI {
    public static void main(String[] args) {
        A643_MaximumAverageSubarrayI solution = new A643_MaximumAverageSubarrayI();
        int[] myInputs = {1,12,-5,-6,50,3};
        int size = 4;
        double myResults = solution.findMaxAverage(myInputs, size);
        System.out.println(myResults);
    }

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        double maxSum = Integer.MIN_VALUE;
        double sum = 0;
        for (int i = 0; i < k; i++){
            sum += nums[i];
        }
        maxSum = Math.max(maxSum, sum);
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }
}
