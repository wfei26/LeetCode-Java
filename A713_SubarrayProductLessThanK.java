public class A713_SubarrayProductLessThanK {
    public static void main(String[] args) {
        A713_SubarrayProductLessThanK solution = new A713_SubarrayProductLessThanK();
        int[] myInputs = {10, 5, 2, 6};
        int target = 100;
        int myResult = solution.numSubarrayProductLessThanK(myInputs, target);
        System.out.println(myResult);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return 0;
        }
        int result = 0;
        int product = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            product *= nums[j];
            while (i <= j && product >= k) {
                product /= nums[i];
                i++;
            }
            result += j - i + 1;
        }
        return result;
    }
}
