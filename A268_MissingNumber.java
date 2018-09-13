public class A268_MissingNumber {
    public static void main(String[] args) {
        A268_MissingNumber solution = new A268_MissingNumber();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int result = solution.missingNumber(nums);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (0 + n) * (n+1) / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
