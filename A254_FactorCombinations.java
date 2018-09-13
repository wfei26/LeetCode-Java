import java.util.ArrayList;
import java.util.List;

public class A254_FactorCombinations {
    public static void main(String[] args){
        A254_FactorCombinations solution = new A254_FactorCombinations();
        int myInput = 32;
        List<List<Integer>> myResults = solution.getFactors(myInput);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> myList = new ArrayList<>();
        backtracking(myList, new ArrayList<>(), n, 2);
        return myList;
    }

    public void backtracking(List<List<Integer>> myList, List<Integer> tempList, int target, int pos) {
        if (target <= 1) {
            if (tempList.size() > 1) {
                myList.add(new ArrayList<>(tempList));
            }
            return;
        }

        for (int i = pos; i <= target; i++) {
            if (target % i == 0) {
                tempList.add(i);
                backtracking(myList, tempList, target / i, i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
