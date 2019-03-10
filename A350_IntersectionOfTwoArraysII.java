import java.util.*;

public class A350_IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        A350_IntersectionOfTwoArraysII solution = new A350_IntersectionOfTwoArraysII();
        int[] input1 = {4,9,5};
        int[] input2 = {9,4,9,8,2};
        int[] output = solution.intersect(input1, input2);
        for (int num : output) {
            System.out.println(num);
        }
    }

    /** Main solution */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                result.add(num);
                map.put(num, map.get(num) - 1);

                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }

    /** Follow up 1: What if the given array is already sorted? How would you optimize your algorithm? */
    /** Solution: use two pointers: similar to merge process in merge sort */


    /** Follow up 2: What if nums1's size is small compared to nums2's size? Which algorithm is better? */
    /** Solution: suppose lengths of two arrays are N and M, the time complexity of my solution is O(N+M) and the space
     * complexity if O(N) considering the hash. So it's better to use the smaller array to construct the counter hash. */


    /** Follow up 3: What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load
     * all elements into the memory at once? */
    /** Solution: if only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array
     * that fit into the memory, and record the intersections. If both nums1 and nums2 are so huge that neither fit
     * into the memory, sort them individually (external sort), then read 2 elements from each array at a time in
     * memory, record intersections.*/
}
