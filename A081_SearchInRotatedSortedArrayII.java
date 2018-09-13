public class A081_SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        A081_SearchInRotatedSortedArrayII solution = new A081_SearchInRotatedSortedArrayII();
        int[] myInputs = {1,1,1,2,1,1,1,1,1,1,1,1,1};
        int target = 2;
        boolean myResult = solution.search(myInputs, target);
        System.out.println(myResult);
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //The only difference compare with the question 33 is the step of deduplicate
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            }
            //MUST USE "else if" instead of "if" because we have to skip binary search step
            //after deduplicate
            else if (nums[left] <= nums[mid]) {
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
            return true;
        }
        else {
            return false;
        }
    }
}
