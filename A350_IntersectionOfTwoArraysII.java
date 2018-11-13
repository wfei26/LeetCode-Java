import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] result = new int[Math.max(nums1.length, nums2.length)];

        //map is used for storing distinct element corresponding with frequency from nums1
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int i = 0;
        for (int num : nums2) {
            //check if map contains num and freq is not 0
            if (map.containsKey(num) && map.get(num) != 0) {
                map.put(num, map.get(num) - 1);
                result[i] = num;
                i++;
            }
        }
        //return subarray from 0 to i
        return Arrays.copyOfRange(result, 0, i);
    }
}
