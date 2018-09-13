public class A034_SearchForARange {
    public static void main(String[] args) {
        A034_SearchForARange solution = new A034_SearchForARange();
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        int[] resultArr = solution.searchRange(nums, target);
        for (int i = 0; i < resultArr.length; i++) {
            System.out.print(resultArr[i] + " ");
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] resultArr = new int[2];
        int leftIndex = searchFirstOccurrence(nums, 0, nums.length-1, target);
        int rightIndex = searchLastOccurrence(nums, 0, nums.length-1, target);
        if (leftIndex == -1 && rightIndex == -1) {
            resultArr[0] = -1;
            resultArr[1] = -1;
            return resultArr;
        }
        resultArr[0] = leftIndex;
        resultArr[1] = rightIndex;
        return resultArr;
    }

    private int searchFirstOccurrence(int[] arr, int left, int right, int target) {
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 || arr[mid-1] < target) && arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                return searchFirstOccurrence(arr, mid+1, right, target);
            }
            else {
                return searchFirstOccurrence(arr, left, mid-1, target);
            }
        }
        return -1;
    }

    private int searchLastOccurrence(int[] arr, int left, int right, int target) {
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if ((mid == arr.length-1 || arr[mid+1] > target) && arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] > target) {
                return searchLastOccurrence(arr, left, mid-1, target);
            }
            else {
                return searchLastOccurrence(arr, mid+1, right, target);
            }
        }
        return -1;
    }
}
