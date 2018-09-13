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
        List<List<Integer>> myList = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(myList, new ArrayList<>(), nums, 0);
        return myList;
    }

    public void backtracking(List<List<Integer>> myList, List<Integer> tempList, int[] nums, int pos) {
        myList.add(new ArrayList<>(tempList));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtracking(myList, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
