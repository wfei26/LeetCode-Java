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
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                if (nums[mid] < target && nums[right] >= target) {
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
