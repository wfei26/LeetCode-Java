public class A674_LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        A674_LongestContinuousIncreasingSubsequence solution = new A674_LongestContinuousIncreasingSubsequence();
        int[] input = {1,3,5,4,2,3,4,5};
        int output = solution.findLengthOfLCIS(input);
        System.out.println(output);
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //curSize means size of current increasing subarray
        //WARNING: MUST INITIALIZE result and curSize to 1, just in case
        //the program does not enter the loop
        //eg: 2,2,2,2,2 => return 1
        int result = 1, curSize = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curSize++;
                result = Math.max(result, curSize);
            }
            //WARNING: reset to current size to 1, not 0!
            else {
                curSize = 1;
            }
        }
        return result;
    }
}
