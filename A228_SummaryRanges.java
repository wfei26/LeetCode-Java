import java.util.ArrayList;
import java.util.List;

public class A228_SummaryRanges {
    public static void main(String[] args) {
        A228_SummaryRanges solution = new A228_SummaryRanges();
        int[] inputs = {0,2,3,4,6,8,9};
        List<String> outputs = solution.summaryRanges(inputs);
        for (String item : outputs) {
            System.out.println(item);
        }
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            //find all consecutive numbers to build current list item
            while (i + 1 < nums.length && (nums[i + 1] - nums[i] == 1)) {
                i++;
            }
            //if there is only one number
            if (start == i) {
                results.add(Integer.toString(nums[i]));
            }
            //if there are many numbers
            else {
                String newItem = Integer.toString(nums[start]) + "->" + Integer.toString(nums[i]);
                results.add(newItem);
            }
            //reset start pointer for next list item
            start = i + 1;
        }
        return results;
    }
}
