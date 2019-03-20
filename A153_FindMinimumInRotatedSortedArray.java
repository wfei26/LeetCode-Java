public class A153_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        A153_FindMinimumInRotatedSortedArray solution = new A153_FindMinimumInRotatedSortedArray();
        int[] myInputs = {3,4,5,1,2};
        int myResult = solution.findMin(myInputs);
        System.out.println(myResult);
    }

    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // KEY POINT: once we find left number is smaller than right number, we find the correct answer
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            int mid = left + (right - left) / 2;
            // WARNING: MUST USE <= at here. eg. for the input 3,1,2, we will search to the left most element, the last
            // condition will determine whether nums[0] <= nums[0]. If we use <, we cannot get the index 1 as our answer
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
