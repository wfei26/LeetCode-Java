public class A035_SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        A035_SearchInsertPosition mySolution = new A035_SearchInsertPosition();
        int result = mySolution.searchInsert(nums, 5);
        System.out.println(result);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
