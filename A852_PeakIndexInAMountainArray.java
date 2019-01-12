public class A852_PeakIndexInAMountainArray {
    public static void main(String[] args) {
        A852_PeakIndexInAMountainArray solution = new A852_PeakIndexInAMountainArray();
        int[] input = {1,2,3,1,0};
        int output = solution.peakIndexInMountainArray(input);
        System.out.println(output);
    }

    public int peakIndexInMountainArray(int[] A) {
        if (A.length < 2) {
            return 0;
        }

        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // DO NOT FORGET to check boundary of mid index
            if (mid > 0 && mid < A.length && A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            }
            // if current item and next item is in ascending order, cut left half
            else if (A[mid] < A[mid + 1]) {
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
