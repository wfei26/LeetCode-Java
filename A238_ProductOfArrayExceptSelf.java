public class A238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        A238_ProductOfArrayExceptSelf solution = new A238_ProductOfArrayExceptSelf();
        int[] myInputs = {3,5,7,9};
        int[] myResults = solution.productExceptSelf(myInputs);
        for (int i = 0; i < myResults.length; i++) {
            System.out.println(myResults[i]);
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] results = new int[len];

        results[0] = 1;
        for (int i = 1; i < len; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            results[i] *= right;
            right *= nums[i];
        }
        return results;
    }
}
