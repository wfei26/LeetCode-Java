import java.util.ArrayList;
import java.util.List;

public class A219_CombinationSumIII {
    public static void main(String[] args){
        A219_CombinationSumIII solution = new A219_CombinationSumIII();
        int input1 = 3;
        int input2 = 9;
        List<List<Integer>> myResults = solution.combinationSum3(input1, input2);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> myList = new ArrayList<>();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        backtracking(myList, new ArrayList<>(), nums, k, n, 0);
        return myList;
    }

    public void backtracking(List<List<Integer>> myList, List<Integer> tempList, int[] nums, int k, int target, int pos) {
        if (target < 0) {
            return;
        }
        if (target == 0 && tempList.size() == k) {
            myList.add(new ArrayList<>(tempList));
        }

        for (int i = pos; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtracking(myList, tempList, nums, k, target - nums[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
