public class A213_HouseRobberII {
    public static void main(String[] args) {
        A213_HouseRobberII solution = new A213_HouseRobberII();
        int[] myInputs = {2};
        int myResult = solution.rob(myInputs);
        System.out.println(myResult);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public int robHelper(int[] nums, int low, int high) {
        int result = 0;
        int oddSum = 0, evenSum = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 ==0) {
                evenSum = Math.max(oddSum, evenSum + nums[i]);
            }
            else {
                oddSum = Math.max(evenSum, oddSum + nums[i]);
            }
        }
        result = Math.max(oddSum, evenSum);
        return result;
    }
}
