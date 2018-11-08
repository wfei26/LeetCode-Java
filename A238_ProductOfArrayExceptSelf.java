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

        //results[i] stores preProduct from 0 to i - 1 except i itself
        //and then update to totalProduct after second iteration
        //DO NOT FORGET to initialize results[0] to 1 because of product
        results[0] = 1;

        //calculate preProduct from left to right
        for (int i = 1; i < len; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }

        //right stores (previous state) right product except current number
        int right = 1;

        //calculate totalProduct from right to left based on preProduct that saved before
        for (int i = len - 1; i >= 0; i--) {
            results[i] *= right; //this right value is from previous state except current number
            right *= nums[i]; //update current right product value
        }
        return results;
    }
}
