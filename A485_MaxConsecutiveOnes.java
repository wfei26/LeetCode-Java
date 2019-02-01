public class A485_MaxConsecutiveOnes {
    public static void main(String[] args) {
        A485_MaxConsecutiveOnes solution = new A485_MaxConsecutiveOnes();
        int[] input = {1,1,0,1,1,1};
        int output = solution.findMaxConsecutiveOnes(input);
        System.out.println(output);
    }

    // easy two pointer solution
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 1) {
                maxLen = Math.max(maxLen, j - i);
                i = j + 1;
            }
            j++;
        }
        maxLen = Math.max(maxLen, j - i);
        return maxLen;
    }
}
