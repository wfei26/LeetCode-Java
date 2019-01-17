public class A268_MissingNumber {
    public static void main(String[] args) {
        A268_MissingNumber solution = new A268_MissingNumber();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int result = solution.missingNumber(nums);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        // xor ^: return 0 if two nums are same, return 1 if two nums are different
        // and x ^ y ^ y = x
        // eg: for array {0, 1, 2, 3, 4, 6}, 5 is missing number
        // then res = 0 ^ 1 ^ 1 ^ 2 ^ 2 ^ 3 ^ 3 ^ 4 ^ 4 ^ 5 ^ 6 = 5 ^ 6
        for (int i = 0; i < n; i++) {
            res = res ^ i ^ nums[i];
        }
        // res = 5 ^ 6, res ^ n = 5 ^ 6 ^ 6 = 5
        return res ^ n;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = (0 + n) * (n+1) / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
