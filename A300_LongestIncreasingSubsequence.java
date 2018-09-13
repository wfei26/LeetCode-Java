public class A300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        A300_LongestIncreasingSubsequence solution = new A300_LongestIncreasingSubsequence();
        int[] myInputs = {10,9,2,5,3,7,101,18};
        int myResult = solution.lengthOfLIS(myInputs);
        System.out.println(myResult);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 0;
        int[] tails = new int[nums.length];

        //(1) if x is larger than all tails, append it, increase the size by 1
        //(2) if tails[i-1] < x <= tails[i], update tails[i]
        for (int item : nums) {
            int left = 0, right = result;

            //Use binary search to find the right position for new item
            while (left != right) {
                int mid = (left + right) / 2;

                //left = right at the first iteration, no need to
                //worry about the tails does not have any items
                if (tails[mid] < item) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }
            tails[left] = item;
            if (left == result) {
                result++;
            }
        }
        return result;
    }
}
