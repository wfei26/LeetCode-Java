import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A039_CombinationSum {
    public static void main(String[] args){
        A039_CombinationSum solution = new A039_CombinationSum();
        int[] myInputs = {2,3,5};
        int myTarget = 8;
        List<List<Integer>> myResults = solution.combinationSum(myInputs, myTarget);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> myList = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(myList, new ArrayList<>(), candidates, target, 0);
        return myList;
    }

    public void backtracking(List<List<Integer>> myList, List<Integer> tempList, int[] nums, int target, int pos) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> newList = new ArrayList<>(tempList);
            myList.add(newList);
        }

        for (int i = pos; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtracking(myList, tempList, nums, target - nums[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
