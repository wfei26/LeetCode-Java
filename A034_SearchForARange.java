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
        int[] resultArr = new int[2];
        resultArr[0] = -1;
        resultArr[1] = -1;
        if (nums.length == 0) {
            return resultArr;
        }

        int leftIndex = searchFirstOccurrence(nums, 0, nums.length-1, target);
        int rightIndex = searchLastOccurrence(nums, 0, nums.length-1, target);
        if (leftIndex == -1 && rightIndex == -1) {
            return resultArr;
        }
        resultArr[0] = leftIndex;
        resultArr[1] = rightIndex;
        return resultArr;
    }

    private int searchFirstOccurrence(int[] arr, int left, int right, int target) {
        while (right > left) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 || arr[mid-1] < target) && arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return arr[left] == target ? left : -1;
    }

    private int searchLastOccurrence(int[] arr, int left, int right, int target) {
        while (right > left) {
            //to avoid infinite loop, we need to bias the left index
            int mid = left + (right - left) / 2 + 1;
            if ((mid == arr.length-1 || arr[mid+1] > target) && arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        return arr[left] == target ? left : -1;
    }
}
