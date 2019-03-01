public class A035_SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        A035_SearchInsertPosition mySolution = new A035_SearchInsertPosition();
        int result = mySolution.searchInsert(nums, 5);
        System.out.println(result);
    }

    /** BS template: left + 1 < right, then check the last two elements after the loop */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // since we have two elements left, so we do not need to do left bias or right bias
            else if (nums[mid] > target) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        // check the last two elements
        if (nums[left] >= target) {
            return left;
        }
        else if (nums[right] == target) {
            return right;
        }
        else if (nums[right] < target) {
            return right + 1;
        }
        return right;
    }
}
