public class A673_NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        A673_NumberOfLongestIncreasingSubsequence solution = new A673_NumberOfLongestIncreasingSubsequence();
        int[] input = {1,3,2};
        int output = solution.findNumberOfLIS(input);
        System.out.println(output);
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int result = 0, maxLen = 0;
        /*
        * Subproblem:
        * lenDP(i) represents maximum length of increasing subsequence end with i
        * countDP(i) represents number of max length of increasing subsequence end with i
        * */
        int[] lenDP = new int[n];
        int[] countDP = new int[n];

        for (int i = 0; i < n; i++) {
            //Base case: re-initialize lenDP(i) and countDP(i) to 1 at the beginning of every iteration
            //because the initial LIS only contains the first item itself
            lenDP[i] = 1;
            countDP[i] = 1;

            //recurrence relations: refers to multiple conditions of state transfer
            for (int j = 0; j < i; j++) {
                //MUST ENSURE that new item (current last item or ith item) is greater than nums[j]
                //to guarantee we have increasing sequence between nums[i] to nums[i]
                if (nums[i] > nums[j]) {

                    //if we count current item (ith item) to the LIS with same max Length (keep the max Length unchanged)
                    //In other words, for any previous states with max length of LIS that 1 less than current state,
                    //increase number of LIS with max length i by total number of LIS of previous state
                    if (lenDP[i] == lenDP[j] + 1) {
                        countDP[i] += countDP[j];
                    }

                    //if we count current item (ith item) to the LIS, but with greater max length
                    //we could use lenDP[i] == lenDP[j] or lenDP[i] < lenDP[j] + 1 at here
                    else if (lenDP[i] < lenDP[j] + 1) {
                        //update current max length, increasing by 1
                        lenDP[i] = lenDP[j] + 1;
                        //keep the number of LIS unchanged, get max count from previous state directly
                        countDP[i] = countDP[j];
                    }
                }
            }

            //if current max length does not change, compare with last state, then adding count value
            //with current max length of LIS
            if (lenDP[i] == maxLen) {
                result += countDP[i];
            }
            //if current max length is greater than previous state, then all count number with smaller length
            //from previous state is no longer needed, update result to new count number
            else if (lenDP[i] > maxLen) {
                maxLen = lenDP[i];
                result = countDP[i];
            }
        }
        return result;
    }
}
