import java.util.HashMap;
import java.util.Stack;

public class A496_NextGreaterElementI {
    public static void main(String[] args) {
        A496_NextGreaterElementI solution = new A496_NextGreaterElementI();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] myResults = solution.nextGreaterElement(nums1, nums2);
        for (int i = 0; i < myResults.length; i++) {
            System.out.println(myResults[i]);
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
