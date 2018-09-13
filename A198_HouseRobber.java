public class A198_HouseRobber {
    public static void main(String[] args) {
        A198_HouseRobber solution = new A198_HouseRobber();
        int[] myInputs = {2,1,7,9,1};
        int myResult = solution.rob(myInputs);
        System.out.println(myResult);
    }

    public int rob(int[] nums) {
        int result = 0;
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum = Math.max(oddSum, evenSum + nums[i]);
            }
            else {
                oddSum = Math.max(evenSum, oddSum + nums[i]);
            }
        }
        result = Math.max(oddSum, evenSum);
        return  result;
    }
}
