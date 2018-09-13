import java.util.ArrayList;
import java.util.List;

public class A046_Permutations {
    public static void main(String[] args){
        A046_Permutations solution = new A046_Permutations();
        int[] inputs = {1,2,3};
        List<List<Integer>> myResults = solution.permute(inputs);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> myList = new ArrayList<>();
        backtracking(myList, new ArrayList<>(), nums);
        return myList;
    }

    public void backtracking(List<List<Integer>> myList, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            myList.add(new ArrayList<>(tempList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            backtracking(myList, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}
