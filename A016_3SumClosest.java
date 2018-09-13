import java.util.Arrays;

public class A016_3SumClosest {
    public static void main(String[] args) {
        A016_3SumClosest solution = new A016_3SumClosest();
        int[] myInputs = {-1,2,1,-4};
        int target = 1;
        int myResult = solution.threeSumClosest(myInputs, target);
        System.out.println(myResult);
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int result = nums[0] + nums[1] +nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int left = i + 1, right = nums.length - 1; left < right;) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    right--;
                }
                else if (sum < target){
                    left++;
                }
                else {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
