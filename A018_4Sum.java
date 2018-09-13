import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A018_4Sum {
    public static void main(String[] args) {
        A018_4Sum solution = new A018_4Sum();
        int[] myInputs = {-1,0,1,2,-1,-4};
        List<List<Integer>> myResults = solution.fourSum(myInputs, -1);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println("\n-----------------------------");
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        //four sum
        for (int k = 0; k < nums.length - 3; k++) {
            //deduplicate
            if (k == 0 || k > 0 && nums[k - 1] != nums[k]) {
                //three sum
                int threeSumTarget = target - nums[k];
                for (int i = k + 1; i < nums.length - 2; i++) {
                    //WARNING: need to change here: i starts from k + 1
                    if (i == k + 1 || (i > k + 1 && nums[i - 1] != nums[i])) {
                        //Two sum
                        int twoSumTarget = threeSumTarget - nums[i];
                        for (int low = i + 1, high = nums.length - 1; low < high;) {
                            if (nums[low] + nums[high] == twoSumTarget) {
                                results.add(Arrays.asList(nums[k], nums[i], nums[low], nums[high]));
                                //deduplicate
                                while (low < high && nums[low] == nums[low + 1]) {
                                    low++;
                                }
                                while (low < high && nums[high] == nums[high - 1]) {
                                    high--;
                                }
                                low++;
                                high--;
                            }
                            else if (nums[low] + nums[high] > twoSumTarget) {
                                high--;
                            }
                            else {
                                low++;
                            }
                        }
                    }
                }
            }
        }
        return results;
    }
}
