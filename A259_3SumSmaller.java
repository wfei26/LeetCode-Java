import java.util.Arrays;

public class A259_3SumSmaller {
    public static void main(String[] args) {
        A259_3SumSmaller solution = new A259_3SumSmaller();
        int[] myInputs = {-2,0,1,3};
        int target = 2;
        int myResult = solution.threeSumSmaller(myInputs, target);
        System.out.println(myResult);
    }

    /**
     * sort the array, traverse from first number to nums.length - 2 number, and then use two pointers to traverse
     * from left most and right most simultaneously. If sum value is greater than or equal to target value, move
     * right pointer to left by 1; otherwise, add all possible results to final result, and then move left pointer
     * to right by 1
     * */
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int left = i + 1, right = nums.length - 1; left < right;) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum >= target) {
                    right--;
                }
                else {
                    // WARNING: if sum is less than target, we must add all candidates to the result
                    // because all numbers between left to right will satisfy the condition, and then they can
                    // be the right number of current sum
                    result += right - left;
                    left++;
                }
            }
        }
        return result;
    }
}
