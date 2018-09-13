import java.util.Arrays;

public class A259_3SumSmaller {
    public static void main(String[] args) {
        A259_3SumSmaller solution = new A259_3SumSmaller();
        int[] myInputs = {-2,0,1,3};
        int target = 2;
        int myResult = solution.threeSumSmaller(myInputs, target);
        System.out.println(myResult);
    }

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
                    //key point!
                    result += right - left;
                    left++;
                }
            }
        }
        return result;
    }
}
