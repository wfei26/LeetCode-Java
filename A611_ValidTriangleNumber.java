import java.util.Arrays;

public class A611_ValidTriangleNumber {
    public static void main(String[] args) {
        A611_ValidTriangleNumber solution = new A611_ValidTriangleNumber();
        int[] myInputs = {2,2,3,4};
        int myResult = solution.triangleNumber(myInputs);
        System.out.println(myResult);
    }

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int result = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            for (int left = 0, right = i - 1; left < right;) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += right - left;
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return result;
    }
}
