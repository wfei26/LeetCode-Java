public class A300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        A300_LongestIncreasingSubsequence solution = new A300_LongestIncreasingSubsequence();
        int[] myInputs = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 8, 10, 12, 13, 16};
        int myResult = solution.lengthOfLIS(myInputs);
        System.out.println(myResult);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 0;

        //store tails of each increasing subsequence with different length
        /*eg: 3, 5, 1, 8, 2, 12
        * 1
        * 1, 2
        * 3, 5, 8
        * 3, 5, 8, 12
        * tails = {1, 2, 8, 12}
        */
        //we do not care about what elements are in each subsequence, we only care about
        //tails of them, because every time we only compare with their tails to decide
        //which subsequence could we add new item and update the entire structure
        int[] tails = new int[nums.length];

        //(1) if x is larger than all tails, append it, increase the size by 1
        //(2) if tails[i-1] < x <= tails[i], update tails[i]
        for (int item : nums) {
            int left = 0, right = result;

            //Use binary search to find the correct tail for new item
            //KEY POINTS: find the smallest ceiling of every new number from the existed tails
            //and replace that ceiling number with new number
            //CORNER CASE: if left = right at the first iteration, so do not need to worry about
            //the tails array does not have any items
            while (left != right) {
                int mid = (left + right) / 2;

                if (tails[mid] < item) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }

            //update tails of current subsequence with length of left + 1
            tails[left] = item;

            //if updated subsequence is the longest one, increase result size by 1
            if (left == result) {
                result++;
            }
        }
        return result;
    }
}
