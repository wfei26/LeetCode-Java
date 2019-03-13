import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A090_SubsetsII {
    public static void main(String[] args){
        A090_SubsetsII solution = new A090_SubsetsII();
        int[] inputs = {1,2,2};
        List<List<Integer>> myResults = solution.subsetsWithDup(inputs);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        // WARNING: DO NOT FORGET to sort to deduplicate!!!
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> tempList, int[] nums, int pos) {
        result.add(new ArrayList<>(tempList));
        for (int i = pos; i < nums.length; i++) {
            // deduplicate
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            dfs(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
