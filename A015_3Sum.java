import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A015_3Sum {
    public static void main(String[] args) {
        A015_3Sum solution = new A015_3Sum();
        int[] myInputs = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> myResults = solution.threeSum(myInputs);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println("\n-----------------------------");
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
                int twoSum = 0 - nums[i];
                for (int low = i + 1, high = nums.length - 1; low < high;) {
                    if (nums[low] + nums[high] == twoSum) {
                        results.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] > twoSum) {
                        high--;
                    }
                    else {
                        low++;
                    }
                }
            }
        }
        return results;
    }
}
