public class A154_FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        A154_FindMinimumInRotatedSortedArrayII solution = new A154_FindMinimumInRotatedSortedArrayII();
        int[] myInputs = {2,2,2,0,1};
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
            //DEDUPLICATE!!!
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}
