public class A153_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        A153_FindMinimumInRotatedSortedArray solution = new A153_FindMinimumInRotatedSortedArray();
        int[] myInputs = {3,4,5,1,2};
        int myResult = solution.findMin(myInputs);
        System.out.println(myResult);
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            //Key point: if left < right, left must be the minimum
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = (right + left) / 2;
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}
