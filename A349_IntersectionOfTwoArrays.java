import java.util.Arrays;
import java.util.HashSet;

public class A349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        A349_IntersectionOfTwoArrays solution = new A349_IntersectionOfTwoArrays();
        int[] input1 = {4,9,5};
        int[] input2 = {9,4,9,8,2};
        int[] output = solution.intersection(input1, input2);
        for (int num : output) {
            System.out.println(num);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] result = new int[Math.max(nums1.length, nums2.length)];

        //set1 is used for storing distinct element from nums1
        //set2 is used for deduplicate when find intersection between nums1 and nums2
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        int i = 0;
        for (int num : nums2) {
            if (set1.contains(num) && set2.add(num)) {
                result[i] = num;
                i++;
            }
        }
        //return subarray from 0 to i
        return Arrays.copyOfRange(result, 0, i);
    }
}
