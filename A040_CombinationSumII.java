import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A040_CombinationSumII {
    public static void main(String[] args){
        A040_CombinationSumII solution = new A040_CombinationSumII();
        int[] myInputs = {10,1,2,7,6,1,5};
        int myTarget = 8;
        List<List<Integer>> myResults = solution.combinationSum2(myInputs, myTarget);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> myList = new ArrayList<>();
        Arrays.sort(candidates);
        backtraking(myList, new ArrayList<>(), candidates, target, 0);
        return myList;
    }

    public void backtraking(List<List<Integer>> myList, List<Integer> tempList, int[] nums, int target, int pos) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            myList.add(new ArrayList<>(tempList));
        }

        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtraking(myList, tempList, nums, target - nums[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
