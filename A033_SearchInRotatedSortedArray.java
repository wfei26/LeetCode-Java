public class A033_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        A033_SearchInRotatedSortedArray solution = new A033_SearchInRotatedSortedArray();
        int[] myInputs = {4,5,6,7,0,1,2};
        int target = 0;
        int myResult = solution.search(myInputs, target);
        System.out.println(myResult);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //if left part is monotonically increasing
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }

            //if right part is monotonically increasing
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        else {
            return -1;
        }
    }
}
