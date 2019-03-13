public class A189_RotateArray {
    public static void main(String[] args) {
        A189_RotateArray solution = new A189_RotateArray();
        int[] input = {1,2,3,4,5,6,7};
        solution.rotate(input, 3);
    }

    // WARNING: DO NOT FORGET to get mod value of k % n
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k % n - 1);
        reverse(nums, k % n, n - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
