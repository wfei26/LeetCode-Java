import java.util.*;

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
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
                set.remove(num);
            }
        }

        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }
}
