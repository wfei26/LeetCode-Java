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
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        //search first and last occurrence of target number
        int leftBound = searchFirstOccurrence(nums, target);
        int rightBound = searchLastOccurrence(nums, target);

        int[] result = new int[2];
        //if does not find target number, return (-1, -1)
        if (leftBound == -1) {
            result[0] = -1;
            result[1] = -1;
        }
        else {
            result[0] = leftBound;
            result[1] = rightBound;
        }
        return result;
    }

    public int searchFirstOccurrence(int[] arr, int num) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //The logic is (A1 || A2) && B
            //where A1 check if current position is 0, A2 check if previous number is distinct
            //B check if current number is target
            if ((mid == 0 || arr[mid - 1] < num) && arr[mid] == num) {
                return mid;
            }
            else if (arr[mid] < num) {
                left = mid + 1;
            }
            //if arr[mid] == num, bias to left since we need to find left bound
            else {
                right = mid;
            }
        }
        return (arr[left] == num) ? left : -1;
    }

    public int searchLastOccurrence(int[] arr, int num) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //just change a little bit from another search function, then keep the rest unchanged
            if ((mid == arr.length - 1 || arr[mid + 1] > num) && arr[mid] == num) {
                return mid;
            }
            else if (arr[mid] > num) {
                right = mid;
            }
            //if arr[mid] == num, bias to right since we need to find right bound
            else {
                left = mid + 1;
            }
        }
        return (arr[left] == num) ? left : -1;
    }
}
