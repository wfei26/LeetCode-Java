import java.util.ArrayList;
import java.util.List;

public class A078_Subsets {
    public static void main(String[] args){
        A078_Subsets solution = new A078_Subsets();
        int[] inputs = {1,2,3};
        List<List<Integer>> myResults = solution.subsets(inputs);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> myList = new ArrayList<>();
        backtracking(myList, new ArrayList<>(), nums, 0);
        return myList;
    }

    public void backtracking(List<List<Integer>> myList, List<Integer> tempList, int[] nums, int pos) {
        myList.add(new ArrayList<>(tempList));
        for (int i = pos; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtracking(myList, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
