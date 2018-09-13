public class A480_SlidingWindowMedian {
    public static void main(String[] args) {
        A480_SlidingWindowMedian solution = new A480_SlidingWindowMedian();
        int[] myInputs = {1,3,-1,-3,5,3,6,7};
        double[] myResults = solution.medianSlidingWindow(myInputs, 3);
        System.out.println(myResults);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] results = new double[n - k + 1];
        if (nums == null || nums.length == 0) {
            return results;
        }

        return results;
    }

}
