public class A162_FindPeakElement {
    public static void main(String[] args) {
        A162_FindPeakElement solution = new A162_FindPeakElement();
        int[] myInputs = {1,2,1,3,5,6,4};
        int myResult = solution.findPeakElement(myInputs);
        System.out.println(myResult);
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == nums.length - 1 || nums[left] > nums[left + 1]) {
            return left;
        }
        else {
            return right;
        }
    }
}
