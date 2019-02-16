import java.util.HashMap;
import java.util.Map;

public class A992_SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        A992_SubarraysWithKDifferentIntegers solution = new A992_SubarraysWithKDifferentIntegers();
        int[] input = {1,2,1,3,4};
        int output = solution.subarraysWithKDistinct(input, 3);
        System.out.println(output);
    }

    /** To calculate subarray with EXACTLY k distinct subarrays, we can calculate subarray with AT MOST k distinct
     * and subarray with k - 1 distinct, the difference between two results will be the final result number */
    public int subarraysWithKDistinct(int[] A, int K) {
        return  subarraysWithAtMostKDistinct(A, K) - subarraysWithAtMostKDistinct(A, K - 1);
    }

    /** use sliding window to calculate number of subarrays with at most k distinct elements */
    public int subarraysWithAtMostKDistinct(int[] A, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int count = 0;
        for (int j = 0; j < A.length; j++) {
            // if new element enter the window, decrease quota by 1 (or increase count by 1)
            if (!map.containsKey(A[j])) {
                count++;
            }
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);

            // if window does not have enough space, move left pointer
            while (count > k) {
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0) {
                    map.remove(A[i]);
                    count--;
                }
                i++;
            }
            // add j - i + 1's valid subarrays
            result += j - i + 1;
        }
        return result;
    }
}
