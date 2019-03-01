import java.util.ArrayList;
import java.util.List;

public class A658_FindKClosestElements {
    public static void main(String[] args) {
        A658_FindKClosestElements solution = new A658_FindKClosestElements();
    }

    /** Use binary search to find closest point in input array, and use two pointers to traverse left side and right
     * side of starting point */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int xIndex = binarySearch(arr, x);
        System.out.println(xIndex);
        for (int i = 0, left = xIndex, right = xIndex; i < k; i++) {
            // initial point
            if (left == right) {
                result.add(arr[left]);
                left--;
                right++;
            }
            // no left number left
            else if (left < 0) {
                result.add(arr[right]);
                right++;
            }
            // no right number left
            else if (right > arr.length - 1) {
                result.add(0, arr[left]);
                left--;
            }
            // general case
            else {
                if (Math.abs(x - arr[left]) <= Math.abs(arr[right] - x)) {
                    result.add(0, arr[left]);
                    left--;
                }
                else {
                    result.add(arr[right]);
                    right++;
                }
            }
        }
        return result;
    }

    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left + 1 < right) {
            if (right == 0) {
                return 0;
            }
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] > target) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        if (target - arr[left] <= arr[right] - target) {
            return left;
        }
        else {
            return right;
        }
    }
}
