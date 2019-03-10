public class A238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        A238_ProductOfArrayExceptSelf solution = new A238_ProductOfArrayExceptSelf();
        int[] myInputs = {3,5,7,9};
        int[] myResults = solution.productExceptSelf(myInputs);
        for (int i = 0; i < myResults.length; i++) {
            System.out.println(myResults[i]);
        }
    }

    /** Scan from left to right ot get pre-product array, and then scan from right to left to get result */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;

        // results[i] stores preProduct from index 0 to index i - 1 except nums[i]
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // rightProduct stores right product except current number
        // WARNING: MUST initialize to 1
        int rightProduct = 1;
        for (int i = n - 1; i > 0; i--) {
            rightProduct *= nums[i];
            result[i - 1] *= rightProduct;
        }
        return result;
    }
}
