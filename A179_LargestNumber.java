import java.util.Arrays;

public class A179_LargestNumber {
    public static void main(String[] args) {
        A179_LargestNumber arranger = new A179_LargestNumber();
        int[] inputs = {3, 30, 34, 5, 9};
        String output = arranger.largestNumber(inputs);
        System.out.println(output);
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        int n = nums.length;
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        //REMEMBER!!! IMPORTANT: JAVA 8 comparator for sorting
        //ascending: (s1 + s2).compareTo(s1 + s2)
        //descending: (s2 + s1).compareTo(s1 + s2)
        Arrays.sort(strArr, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        //corner case: "00000..." leading 0 at the beginning
        if (strArr[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
