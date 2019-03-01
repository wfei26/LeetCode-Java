public class A034_SearchForARange {
    public static void main(String[] args) {
        A034_SearchForARange solution = new A034_SearchForARange();
        int[] nums = {1};
        int target = 1;
        int[] resultArr = solution.searchRange(nums, target);
        for (int i = 0; i < resultArr.length; i++) {
            System.out.print(resultArr[i] + " ");
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = searchFirst(nums, target);
        int last = searchLast(nums, target);

        if (first == -1 || last == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{first, last};
    }

    /** Binary Search left <= right template: deal with everything in the loop */
    public int searchFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // WARNING: MUST use (A || B) && C logic at here, but CANNOT use A && C || B && C logic
            // (since B condition may exist out of boundary problem)
            if ((mid == 0 || nums[mid - 1] != target) && nums[mid] == target) {
                return mid;
            }
            // if it does not satisfies above condition, but current mid number still equal to target, we need to
            // find correct position in the left half since we are trying to search first occurrence of target
            else if (nums[mid] >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        // corner case: if all left side are same number
        return nums[0] == target ? 0 : -1;
    }

    /** Binary Search left <= right template: deal with everything in the loop */
    public int searchLast(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == n - 1 || nums[mid + 1] != target) && nums[mid] == target) {
                return mid;
            }
            // if it does not satisfies above condition, but current mid number still equal to target, we need to
            // find correct position in the right half since we are trying to search last occurrence of target
            else if (nums[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        // corner case: if all right side are same number
        return nums[n - 1] == target ? n - 1 : -1;
    }
}
