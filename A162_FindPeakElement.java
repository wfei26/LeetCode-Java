public class A162_FindPeakElement {
    public static void main(String[] args) {
        A162_FindPeakElement solution = new A162_FindPeakElement();
        int[] myInputs = {3,2,1};
        int myResult = solution.findPeakElement(myInputs);
        System.out.println(myResult);
    }

    /** always compare two adjacent values to decide monotonic property. eg: mid and mid + 1 */
    public int findPeakElement(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // DO NOT FORGET to check boundary of mid index
            if (mid > 0 && mid < nums.length && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // if current item and next item is in ascending order, cut left half
            else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            // if current item and next item is in descending order, cut right half
            else {
                right = mid;
            }
        }
        return left;
    }
}
