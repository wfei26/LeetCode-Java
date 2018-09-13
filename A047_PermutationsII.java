import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A047_PermutationsII {
    public static void main(String[] args){
        A047_PermutationsII solution = new A047_PermutationsII();
        int[] inputs = {1,1,2};
        List<List<Integer>> myResults = solution.permuteUnique(inputs);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> myList = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] ifUsed = new boolean[nums.length];
        backtracking(myList, new ArrayList<>(), nums, ifUsed);
        return myList;
    }

    public void backtracking(List<List<Integer>> myList, List<Integer> tempList, int[] nums, boolean[] ifUsed) {
        if (tempList.size() == nums.length) {
            myList.add(new ArrayList<>(tempList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (ifUsed[i] || i > 0 && !ifUsed[i - 1]  && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            ifUsed[i] = true;
            backtracking(myList, tempList, nums, ifUsed);
            ifUsed[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
